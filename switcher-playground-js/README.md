This tutorial demonstrates the essential steps to set up your first Switcher feature toggle.
You'll learn how to configure the API using Switcher Management, integrate the SDK into your application, and implement feature toggle calls.

## Setting Up Your Domain and Switcher

1. **Access your account** at https://cloud.switcherapi.com

2. **Create your first Domain**
   - A Domain functions like a GitHub Organization, serving as a container for all your projects and feature toggles.

3. **Create a Group**
   - Groups help organize Switchers by release, project, or feature set for better management.

4. **Create your first Switcher**
   - A Switcher is the core element that controls whether a feature is enabled or disabled (returns true or false).

5. **Create a Component**
   - Components represent your applications. Each application receives a unique API Key for secure access.
   - **Important**: After creating a component, you'll receive an API Key. Store it securely as you'll need it for integration.

6. **Associate the Switcher with your Component**
   - Navigate back to the Switcher you just created
   - Click "Edit" and assign it to the component you created
   - This ensures only your authorized application can access this Switcher

## Integrating the SDK into Your Project

1. **Install the switcher-client SDK**
   ```bash
   npm install switcher-client
   ```

2. **Configure the client context**
   - Create a configuration file to initialize the client and export Switcher functions for use throughout your application.

3. **Explore advanced features**
   - Check out the [documentation](https://github.com/switcherapi/switcher-client-js) for comprehensive details about all available features and configuration options.