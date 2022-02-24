<template>
    <div class="hello">
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
            <b-form-group
                id="input-group-1"
                label="Inserte su e-mail"
                label-for="input-1"
            >
                <b-form-input
                    id="input-1"
                    v-model="form.email"
                    type="email"
                    placeholder="Ingrese su email"
                    required
                ></b-form-input>
            </b-form-group>

            <b-form-group
                id="input-group-2"
                label="Su nombre:"
                label-for="input-2"
            >
                <b-form-input
                    id="input-2"
                    v-model="form.name"
                    placeholder="Ingrese su nombre"
                    required
                ></b-form-input>
            </b-form-group>

            <b-form-group
                id="input-group-3"
                label="Su apellido"
                label-for="input-2"
            >
                <b-form-input
                    id="input-2"
                    v-model="form.lastName"
                    placeholder="Ingrese su apellido"
                    required
                ></b-form-input>
            </b-form-group>

            <b-button type="submit" variant="primary">Submit</b-button>
            <b-button type="reset" variant="danger">Reset</b-button>
        </b-form>
        <!-- <b-card class="mt-3" header="Form Data Result">
            <pre class="m-0">{{ form }}</pre>
        </b-card> -->
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: "AddCustomer",
    props: {
        msg: String,
    },
    data() {
        return {
            form: {
                email: "",
                name: "",
                lastName: "",
            },
            show: true,
        };
    },
    methods: {
        onSubmit(event) {
            event.preventDefault();
            axios
                .post("http://localhost:8181/ms-customer/v1/api/customer/save", this.form)
                .then(function (response) {
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        onReset(event) {
            event.preventDefault();
            // Reset our form values
            this.form.email = "";
            this.form.name = "";
            this.form.lastName = "";
            // Trick to reset/clear native browser form validation state
            this.show = false;
            this.$nextTick(() => {
                this.show = true;
            });
        },
    },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
    margin: 40px 0 0;
}
ul {
    list-style-type: none;
    padding: 0;
}
li {
    display: inline-block;
    margin: 0 10px;
}
a {
    color: #42b983;
}
.hello {
    margin: 25px 25rem;
}
</style>
