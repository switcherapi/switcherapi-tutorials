/*
This tutorial shows the minimum necessary to set up your first Switcher.
Firstly, you will be configuring the API using the Switcher Management, 
importing the SDK to your application and finally implementing the call.

-> Setup your Domain and your Switcher.
    1. Access your account at https://cloud.switcherapi.com

    2. Create your first Domain.
        * Domain is something similar to a GitHub Organization where you maintain all your projects.

    3. Create a Group.
        * Groups is a good way to organize Switchers from the same release or project.

    4. Create your first Switcher.
        * Switcher is the main element that defines if the result is going to be A or B.

    5. Create a Component.
        * Components are literally applications. Each app will use an unique API Key.
        * After creating a component, you will be given an API Key. Save it a secure place.

    6. Return to the Switcher page you've just created. 
    Select Edit and assign it with the component you have created. 
        * This step will assure that only your application can use this Switcher.

That's it! Now, let's move to the code part:
-> Import the switcher-client SDK to your project.
    1. run the following: npm install switcher-client
        * It will import our super lightweight library to your project

    2. Configure the context
        * You can define a single JS to initialize the client and export Switcher functions.

    3. Check out the documentation for more details about all available features.
*/

const { Switcher, checkValue } = require('switcher-client');

const context = {
    url: 'https://switcherapi.com/api',
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

async function run(_exit = false) {
    const switcher = Switcher.factory();
    await switcher.isItOn('MY_SWITCHER', [checkValue('user_2')]);
    console.log(JSON.stringify(Switcher.getLogger('MY_SWITCHER'), null, 4));
}

run();