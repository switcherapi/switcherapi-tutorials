import { Switcher, checkValue } from 'switcher-client';

function setupSdk() {
    const context = {
        url: 'https://api.switcherapi.com',
        apiKey: 'JDJiJDA4JEFweTZjSTR2bE9pUjNJOUYvRy9raC4vRS80Q2tzUnk1d3o1aXFmS2o5eWJmVW11cjR0ODNT',
        domain: 'Playground',
        component: 'switcher-playground',
    };
    
    const options = {
        logger: true,
        offline: true,
        snapshotLocation: './snapshot',
    };
    
    Switcher.buildContext(context, options);
    Switcher.loadSnapshot().then(() => console.log('Snapshot loaded!'));
}

async function run() {
    const switcher = Switcher.factory();
    const response = await switcher.detail().isItOn('MY_SWITCHER', [checkValue('user_2')]);
    console.log(response);
}

setupSdk();
run();