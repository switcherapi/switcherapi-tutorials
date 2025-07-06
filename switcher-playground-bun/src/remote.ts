/**
 * Switcher Playground - Remote Example
 * This example demonstrates how to use the Switcher Client SDK with remote API calls.
 */

import {Client } from 'switcher-client';

async function setupSdk() {
    Client.buildContext({
        url: 'https://api.switcherapi.com',
        apiKey: process.env.API_KEY,
        domain: 'Switcher API',
        component: 'switcher-client-js',
    });
}

async function run() {
    await setupSdk();
    const switcher = Client.getSwitcher();

    setInterval(async () => {
        const time = Date.now();
        const result = await switcher
            .detail()
            .isItOn('CLIENT_JS_FEATURE');

        console.log(`- ${Date.now() - time} ms - ${JSON.stringify(result)}`);
    }, 1000);
}

run();