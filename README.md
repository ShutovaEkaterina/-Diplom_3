# -Diplom_3

# запуск с Firefox, так как yandex browser не завелся
`mvn -Dbrowser=firefox test`

# запуск с Chrome
`mvn test`

# Запуск отчета Allure в браузере
`mvn allure:serve`

Тест LogoutTest будет падать с ошибкой в обоих браузерах, так как в задании текст кнопки отличается для логаута
