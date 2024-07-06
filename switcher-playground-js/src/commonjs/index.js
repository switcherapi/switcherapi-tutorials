const loadModule = require('./switcher-client-async.js');

async function setupSdk() {
    const { Client } = await loadModule();

    Client.buildContext({
        url: 'https://api.switcherapi.com',
        apiKey: 'JDJiJDA4JEFweTZjSTR2bE9pUjNJOUYvRy9raC4vRS80Q2tzUnk1d3o1aXFmS2o5eWJmVW11cjR0ODNT',
        domain: 'Playground',
        component: 'switcher-playground'
    }, {
        logger: true,
        local: true,
        snapshotLocation: './snapshot'
    });

    Client.loadSnapshot().then(() => console.log('Snapshot loaded!'));
    Client.subscribeNotifyError((error) => console.error('NotifyError:', error));
    Client.watchSnapshot({
        success: (snapshot) => console.log('Snapshot updated:', snapshot),
    });
}

async function run() {
    const { Client } = await loadModule();
    
    const switcher = Client.getSwitcher();
    
    setInterval(async () => {
        const time = Date.now();
        const result = await switcher.detail().isItOn('MY_SWITCHER');
        console.log(`- ${Date.now() - time} ms - ${JSON.stringify(result)}`);
    }, 1000);
}

setupSdk();
run();