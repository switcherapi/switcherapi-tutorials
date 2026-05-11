.PHONY: install-test install play test test-parallel

install-test:
	pip install -r requirements.txt --index-url https://test.pypi.org/simple/ --extra-index-url https://pypi.org/simple/

install:
	pip install -r requirements.txt

play:
	python src/main.py

test:
	pytest tests/test_sample.py -vv

test-parallel:
	pytest tests/test_sample.py -n 2 -vv
