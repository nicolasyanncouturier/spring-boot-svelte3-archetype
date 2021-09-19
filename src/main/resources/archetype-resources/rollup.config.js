/* jshint esversion: 6 */
/* jshint -W097 */
"use strict";

import babel from "@rollup/plugin-babel";
import commonjs from "@rollup/plugin-commonjs";
import resolve from '@rollup/plugin-node-resolve';
import svelte from 'rollup-plugin-svelte';


export default [
    "ExampleView",
    ].flatMap(source => ([
    {
        input: 'src/main/js/' + source + '.svelte',
        output: {
            // The destination for our bundled JavaScript
            file: 'target/classes/static/' + source + '.js',
            // Our bundle will be an Immediately-Invoked Function Expression
            format: 'iife',
            // The IIFE return value will be assigned into a variable called `app`
            name: 'app',
        },
        plugins: [
            svelte({
                // Tell the svelte plugin where our svelte files are located
                include: 'src/main/js/**/*.svelte',
                emitCss: false
            }),
            babel(),
            resolve(),
            commonjs(),
            // Tell any third-party plugins that we're building for the browser
            resolve({ browser: true }),
        ]
    },
    {
        input: 'src/main/js/' + source + '.svelte',
        output: {
            // The destination for our bundled JavaScript
            file: 'target/classes/' + source + '.js',
            // Our bundle will be an Immediately-Invoked Function Expression
            format: 'iife',
            // The IIFE return value will be assigned into a variable called `app`
            name: 'app'
        },
        plugins: [
            svelte({
                // Tell the svelte plugin where our svelte files are located
                include: 'src/main/js/**/*.svelte',

                // Emit CSS as "files" for other plugins to process. default is true
                emitCss: false,

                // You can pass any of the Svelte compiler options
                compilerOptions: {

                    // By default, the client-side compiler is used. You
                    // can also use the server-side rendering compiler
                    generate: 'ssr',

                    // ensure that extra attributes are added to head
                    // elements for hydration (used with generate: 'ssr')
                    hydratable: true,

                    // You can optionally set 'customElement' to 'true' to compile
                    // your components to custom elements (aka web elements)
                    customElement: false
                }
            }),
            babel(),
            resolve(),
            commonjs(),
            // Tell any third-party plugins that we're building for the browser
            resolve({ browser: true }),
        ]
    }
]));