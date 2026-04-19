""" Main file for Switcher client examples. """

import threading
import time
import os

from dotenv import load_dotenv
from switcher_client import Client, ContextOptions

from util import monitor_run

load_dotenv()
API_KEY = os.getenv('SWITCHER_API_KEY')
SWITCHER_KEY = 'CLIENT_PYTHON_FEATURE'
LOOP = True

def setup_sdk(options: ContextOptions = ContextOptions(), environment = "default"):
    """ Setup the global context for the Switcher client. """
    Client.build_context(
        domain='Switcher API',
        url='https://api.switcherapi.com',
        api_key=API_KEY,
        component='switcher-client-python',
        environment=environment,
        options=options
    )

def check_switcher():
    """ Use case: Check Switcher using remote API """
    setup_sdk(ContextOptions(
        local=False
    ))

    switcher = Client.get_switcher(SWITCHER_KEY)

    monitor_thread = threading.Thread(target=monitor_run, args=(switcher,), daemon=True)
    monitor_thread.start()

if __name__ == "__main__":
    try:
        check_switcher()
        while LOOP:
            time.sleep(1)
    except KeyboardInterrupt:
        print("\nStopping...")
