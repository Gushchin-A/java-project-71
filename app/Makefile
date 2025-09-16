# переменная для аргументов. по дефолту пустая
ARGS ?=

run-dist: # запуск исполняемого файла
	@./build/install/app/bin/app $(ARGS)

run: # короткий вариант запуска исполняемого файла
	@./build/install/app/bin/app $(ARGS)

build: # сборка проекта
	./gradlew build

.PHONY: build