<script>
    import Container from './Container.svelte';

    export let counter = 0;
    function increment() {
        counter++;
    }
</script>

<Container>
    <div class="row">
        <div class="col">
            <h1>spring-boot-svelte3-demo</h1>
        </div>
    </div>
    <div class="row">
        <div class="col">
            counter: {counter}
        </div>
        <div class="col">
            <button type="button" class="btn btn-primary" on:click={increment}>Increment</button>
        </div>
    </div>
</Container>

<style>

</style>