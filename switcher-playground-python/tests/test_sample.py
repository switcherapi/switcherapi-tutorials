from switcher_client import Client
import pytest

from src.dummy_app import SWITCHER_KEY, dummy_function, setup_sdk

@pytest.fixture(autouse=True)
def setup_switcher_context():
    setup_sdk()

@pytest.mark.parametrize(
    "assumption, expected",
    [
        ("on", 0),
        ("off", 1),
    ],
)
def test_dummy_function_same_flag_parallel_cases(assumption, expected):
    """Validate two cases on the same feature flag; suitable for parallel runs."""
    if assumption == "on":
        Client.assume(SWITCHER_KEY).true()
    else:
        Client.assume(SWITCHER_KEY).false()

    result = dummy_function()
    assert result == expected