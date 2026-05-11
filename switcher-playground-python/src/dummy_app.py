""" Dummy app for testing purposes """

import os
import time

from dotenv import load_dotenv
from switcher_client import Client

load_dotenv()
API_KEY = os.getenv('SWITCHER_API_KEY')
SWITCHER_KEY = 'CLIENT_PYTHON_FEATURE'
LOOP = True

def setup_sdk():
    """ Setup the global context for the Switcher client. """
    Client.build_context(domain='Switcher API')

def dummy_function():
    """ Dummy function for testing purposes. """
    switcher = Client.get_switcher(SWITCHER_KEY)
    time.sleep(2)

    if switcher.is_on():
        return 0
    return 1
