/**
 * Switcher Playground - Hybrid Snapshot Example
 * This example demonstrates how to use the Switcher Client SDK with a snapshot loaded from the remote API.
 */

import { Client } from 'switcher-client';

async function setupSdk() {
    Client.buildContext({
        url: 'https://api.switcherapi.com',
        apiKey: process.env.API_KEY,
        domain: 'Switcher API',
        component: 'switcher-client-js',
    }, {
        local: true
    });

    await Client.loadSnapshot({ fetchRemote: true });;
}

async function run() {
    await setupSdk();
    const switcher = Client.getSwitcher();

    setInterval(() => {
        const time = Date.now();
        const result = switcher.isItOnDetail('CLIENT_JS_FEATURE');

        console.log(`- ${Date.now() - time} ms - ${JSON.stringify(result)}`);
    }, 1000);
}

run();