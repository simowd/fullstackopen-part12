<template>
    <div class="home">
        <b-table striped hover :items="customers"></b-table>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: "ListComponent",
    components: {},
    data() {
        return {
            customers: null,
        };
    },
    beforeMount() {
        var ctx = this;
        axios
            .get("http://localhost:8181/ms-customer/v1/api/customer/all")
            .then(function (response) {
                // handle success
                console.log(response);
                ctx.customers = response.data;
            })
            .catch(function (error) {
                // handle error
                console.log(error);
            });
    },
};
</script>
