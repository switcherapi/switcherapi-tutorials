import { Client, type SwitcherContext, type SwitcherOptions } from 'switcher-client';

async function setupSdk() {
    const context: SwitcherContext = {
        url: 'https://api.switcherapi.com',
        apiKey: 'JDJiJDA4JEFweTZjSTR2bE9pUjNJOUYvRy9raC4vRS80Q2tzUnk1d3o1aXFmS2o5eWJmVW11cjR0ODNT',
        domain: 'Playground',
        component: 'switcher-playground',
    };
    
    const options: SwitcherOptions = {
        regexSafe: false, // false required (Bun cannot handle child process) 
        local: true,
        snapshotLocation: './snapshot',
    };
    
    Client.buildContext(context, options);
    Client.watchSnapshot({
        success: () => console.log('Snapshot updated!'),
        reject: (error) => console.error('Snapshot update failed!', error),
    });

    await Client.loadSnapshot().then(() => console.log('Snapshot loaded!'));
}

async function run() {
    await setupSdk();

    const switcher = Client.getSwitcher().detail().defaultResult(false);

    setInterval(async () => {
        const time = Date.now();
        const result = await switcher.isItOn('MY_SWITCHER');
        console.log(`- ${Date.now() - time} ms - ${JSON.stringify(result)}`);
    }, 1000);
}

run();