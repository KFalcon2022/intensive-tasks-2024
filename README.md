# Структура репозитория

Репозиторий разбит на 5 глав и содержит 20 тематических задач. Каждая задача находится в своем
пакете.

Найти Разделы с задачами можно по пути:
`{intensive-tasks}/src/main/java/com/walking/intensive`.

Последние две задачи (Глава 5) являются дополнительными - они ощутимо сложнее остальных.
Интенсив считается пройденным успешно, если засчитаны 18 задач.

Каждая задача предполагает реализацию метода (или методов) в классе `TaskN`, где `N` - номер задачи.
Условие можно найти внутри классов

Кроме того, каждый класс Task-класс содержит пустой метод `main()`, который вы можете использовать
для самостоятельной проверки своего решения в любой удобной вам форме.

# Работа с репозиторием

Заранее рекомендую ознакомиться со статьями:

1. [Системы контроля версий. Git. Github](https://telegra.ph/Sistemy-kontrolya-versij-Git-Github-11-18)
2. [GitHub. Fork и Pull Request](https://telegra.ph/GitHub-Fork-i-Pull-Request-11-25).

По мере сил, каждое действий ниже будет снабжаться ссылкой с краткой инструкцией

Для выполнения задач требуется сделать fork репозитория в GitHub.
Коротко
[здесь](https://git-scm.com/book/ru/v2/GitHub-%D0%92%D0%BD%D0%B5%D1%81%D0%B5%D0%BD%D0%B8%D0%B5-%D1%81%D0%BE%D0%B1%D1%81%D1%82%D0%B2%D0%B5%D0%BD%D0%BD%D0%BE%D0%B3%D0%BE-%D0%B2%D0%BA%D0%BB%D0%B0%D0%B4%D0%B0-%D0%B2-%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D1%8B#:~:text=%D0%A1%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%BE%D1%82%D0%B2%D0%B5%D1%82%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D0%B9%20(fork))

После этого полученную копию проекта требуется склонировать на свой компьютер.
Коротко
[здесь](https://docs.github.com/ru/repositories/creating-and-managing-repositories/cloning-a-repository#cloning-a-repository)

Также вам может потребоваться актуализировать свою копию, для получения обновлений из оригинального репозитория. О
необходимости этого действия будут соответствующие объявления в чате. Коротко о синхронизации
[здесь](https://docs.github.com/ru/pull-requests/collaborating-with-pull-requests/working-with-forks/syncing-a-fork#syncing-a-fork-branch-from-the-web-ui)

Так же у нас есть видео [инструкция](https://youtu.be/FInK62h801o)

## Алгоритм выполнения и отправки задач на проверку

Для каждой задачи:

1. Создаем ветку (от `master`) с номером задачи в названии. Например: `task1`. Создание веток в
   IDEA: [ссылка](https://www.jetbrains.com/help/idea/manage-branches.html).
   Интерфейс на скриншотах может отличаться от привычного вам. Тогда
   смотрим [здесь](https://www.jetbrains.com/help/idea/2022.3/manage-branches.html)
2. Решаем задачу, проверяем ее с помощью `main()`.
3. Создаем коммит с решением. В нем должен быть изменен только один класс (кроме задачи 19), убедитесь,
   что не добавили ничего лишнего.
4. Делаем Push коммита.
5. Создаем Pull Request на ветку `master` в основном репозитории.
   Коротко [здесь](https://docs.github.com/ru/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request-from-a-fork)
6. Название Pull Request должно быть указано в формате "Task N", где N - номер задачи.
7. При получении замечаний по решению, исправляем их и пушим коммит с правками. По возможности все изменения 
   после ревью стоит добавлять одним коммитом. 
8. Оповещаем ревьюера, если знаете, кто проверял ваш код.

### Запуск тестов

После выполнения задачи вы также можете проверить корректность решения с помощью тестов.
Тесты для задачи можно найти в проекте по пути:
`{intensive-tasks}/src/test/java/com/walking/intensive/{your-task-chapter}/{your-task}`.

Если вы видите там класс с постфиксом `Test` - откройте его. Слева от названия класса будет зеленая кнопка, по которой
откроется выпадающий список. Запустите тесты, выбрав опцию `Run {TestClassName}`.

В открывшейся внизу вкладке вы можете увидеть результаты тестирования для различных тестовых данных. Если какие-то
(или все) результаты помечены желтым или красным - выберите каждый из упавших тестов и сравните ожидаемый (expected)
и реальный (actual) результаты выполнения. Последний - результат вызова вашего метода. Разберитесь, почему
результаты отличаются и исправьте недочеты.

## Правила оформления кода

Перед тем как сдать задачу на проверку:

1. Код должен быть выровнен: `CTRL` + `ALT` + `L` (Windows, Linux), `⌘` + `⌥` + `L` (Mac).
2. Отделяйте логические блоки кода пустыми строками, это повышает читаемость.
3. Старайтесь создавать информативные имена без транслита. Короткие имена допускаются только для переменных цикла (i, j,
   k) или если они оправданы темой задачи (a, b и c - как стороны треугольника или коэффициенты уравнения). Пример
   корректного именования: переменная «определитель матрицы» - `matrixDeterminant`.
4. При создании имен в Java используется [camelCase](https://ru.wikipedia.org/wiki/CamelCase). Это способ написания
   имен (переменных, методов и т.д.) без пробелов, начиная с маленькой буквы (кроме имен классов), где каждое следующее
   новое слово начинается с заглавной буквы. Пример имени метода: `getMatrixDeterminant()`.
5. Имена классов пишутся с большой буквы.
6. Имена пакетов (папок) пишутся с маленькой буквы.
7. Имена классов и переменных – существительные. Имена методов – начинаются с глагола: get, print и т.д.
   Например: `getSum()`, `calculateExpression()`.
8. boolean-переменные и методы, которые возвращает `boolean`, лучше стараться именовать со слова is.
   Примеры: `boolean isLeap = false;`, `isLeapYear()`.
9. Фигурные скобки после условной конструкции (`if`/`else`) и циклов должны стоять даже если тело блока состоит из
   одной строчки.

Удачи!
