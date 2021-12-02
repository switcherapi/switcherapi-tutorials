/*
This tutorial shows the minimum necessary to set up your first Switcher.
Firstly, you will be configuring the API using the Switcher Management, 
importing the SDK to your application and finally implementing the call.

-> Setup your Domain and your Switcher.
    1. Access your account at https://switcherapi.github.io/switcher-management/

    2. Create your first Domain.
        * Domain is something similar to a GitHub Organization where you maintain all your projects.

    3. Create a Group.
        * Groups is a good way to organize Switchers from the same release or project.

    4. Create your first Switcher.
        * Switcher is the main element that defines if the result is going to be A or B.

    5. Create a Component.
        * Components are literally applications. Each app needs to assign an API Key.
        * After creating a component, you will be given an API Key. Save it a secure place.

    6. Return to the Switcher page you've just created. 
    Select Edit and assign it with the component you have created. 
        * This step will assure that only your application can use this Switcher.

That's it! Now, let's move to the code part:
-> Import the switcher-client SDK to your project.
    1. run the following: npm install switcher-client
        * It will import our super lightweight library to your project

    2. Import the library on your project's startup procedure section.
        * Like we do when importing Express or Mongoose, just do the same with Switcher.

    3. Configure the context
        * Context is all necessary arguments such as API URL, Domain and Component name
        * and of course the API Key. Make sure to not expose it.
    
    4. Call your Switcher using the following: Switcher.factory().isItOn('[MY_SWITCHER]')
*/

const { Switcher, checkValue } = require('switcher-client');

const domain = 'Playground';
const component = 'switcher-playground';
const apiKey = '$2b$08$Hm77RoqpXb.1f7izs06uKendX.B1jjWqTZsfJAzYnFoRzJpEFQXEi';
Switcher.buildContext({ apiKey, component, domain }, { offline: false });
Switcher.loadSnapshot();

const switcher = Switcher.factory();
switcher.throttle(4000);

async function run(exit = false) {
    switcher.prepare('MY_SWITCHER', [checkValue('user_1')]);

    for (let index = 0; index < 100; index++) {
        console.log(await switcher.isItOn());
    }

    process.exit();
}

run();