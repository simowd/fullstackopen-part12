const express = require('express');
const { Todo } = require('../mongo')
const router = express.Router();
const redis = require('../redis');

/* GET todos listing. */
router.get('/', async (_, res) => {
  const todos = await Todo.find({})
  res.send(todos);
});

/* POST todo to listing. */
router.post('/', async (req, res) => {
  const todo = await Todo.create({
    text: req.body.text,
    done: false
  })

  const getCounter = await redis.getAsync("added_todos");

  if (getCounter) {
    await redis.setAsync("added_todos", Number(getCounter) + 1 );
  }
  else {
    await redis.setAsync("added_todos", 1);
  }
  //redis.setAsync("added_todos", )
  res.send(todo);
});

router.get('/statistics', async (_, res) => {
  const counter = await redis.getAsync("added_todos");
  if (counter) {
    res.send({
      "added_todos": counter
    });
  }
  else {
    const newC = await redis.setAsync("added_todos", 0);
    res.send({
      "added_todos": 0
    });
  }
});

const singleRouter = express.Router();

const findByIdMiddleware = async (req, res, next) => {
  const { id } = req.params
  req.todo = await Todo.findById(id)
  if (!req.todo) return res.sendStatus(404)

  next()
}

/* DELETE todo. */
singleRouter.delete('/', async (req, res) => {
  await req.todo.delete()
  res.sendStatus(200);
});

/* GET todo. */
singleRouter.get('/', async (req, res) => {
  const todo = await Todo.findById(req.params.id);
  res.send(todo);
});

/* PUT todo. */
singleRouter.put('/', async (req, res) => {
  const todo = await Todo.findByIdAndUpdate(req.params.id, req.body);
  res.send(todo);
});

router.use('/:id', findByIdMiddleware, singleRouter)


module.exports = router;
