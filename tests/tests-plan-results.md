﻿## Тест-план проекта Cinema
## **1. Введение**
Данный файл содержит тест-план приложения **Cinema**. Основной целью тестирования является проверка приложения на соответствие требованиям SRS.
## **2. Объекты тестирования**
Объект тестирования - приложение **Cinema**.
Функция, которую выполняет данное приложение - предоставление пользователю информации о текущих фильмах в прокате, а также возможности купить билет на понравившийся.
1. Функциональность:
 - Функциональная полнота: приложение обязано иметь все заявленные функции в соответствии с SRS;
 - Функциональная корректность: приложение должно выполнять все заявленные функции;
 - Функциональная целесообразность: отсутствуют незаявленные функции, которые бы мешали приложению выполнять первоначально поставленные задачи.
2. Удобство использования:
- Минималистичность: приложение выполняет только конкретные задачи пользователя.

## **3. Риски**
К рискам можно отнести следующие пункты:
-   Особенности внешнего вида на разных экранах рабочих устройств;
## **4. Аспекты тестирования**
К аспектам тестирования относится реализация основных функций приложения:

-   Возможность регистрации в системе;
-   Возможность покупки билета на фильм;
-   Возможность поиска фильма по критериям;
-   Возможность отмены фильма в личном кабинете;
-   Возможность редактирования профиля;

#### Функциональные требования:

##### Возможность регистрации в системе

Этот вариант использования необходимо протестировать на:

1.  Верификацию введенных данных
2.  Кликабельность кнопок

##### Возможность покупки билета на фильм

Этот вариант использования необходимо протестировать на:

1.  Обновление списка фильмов
2.  Обновление информации пользователя
3.  Кликабельность кнопок
##### Возможность поиска фильма по критериям
1. Обновление списка фильмов по введённому критерию поиска

##### Возможность отмены фильма в личном кабинете

Этот вариант использования небходимо протестировать на:

1.  Обновление списка фильмов в личном профиле
2.  Кликабельность кнопок
##### Возможность редактирования профиля
1. Обновление информации о пользователе

#### Нефункциональные требования:

1.  Производительность. Минимальное время обработки запроса
## **5. Подходы к тестированию**
Каждый аспект тестирования был произведен с помощью системного тестирования.  
Системное тестирование - это тестирование программы в целом.  
Каждый тест производится вручную.  
Такой метод подходит для небольших проектов.
## **6. Представление результатов**

| Case Id | Case Description                             | Steps                                                                                                       | Expected Results                                                         | Action Results                                                            | Pass/Fail |
|---------|----------------------------------------------|-------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------|---------------------------------------------------------------------------|-----------|
|    1    | Регистрация  пользователя                    | 1.Заполнение всех необходимы  полей 2.Нажатие кнопки "Register"                                           | Сообщение об успешной  регистрации                                       | Сообщение об успешной регистрации                                         |    Pass   |
|    2    | Возможность покупки  билета на фильм         | 1. Нажатие кнопки "Buy a ticket"                                                                            | Отображение страницы  сообщающая об успешной покупке билета на фильм.    | Отображение страницы  сообщающей об успешной покупке билета на фильм.     |    Pass   |
|    3    | Возможность поиска  фильма по критериям      | 1. Нажатие кнопки "Search" 2.Выбор критерий для поиска                                                     | Отображение страницы со списком фильмов удовлетворяющих критериям поиска | Отображение страницы со списком фильмов удовлетворяющих критериям поиска  |    Pass   |
|    4    | Возможность отмены фильма  в личном кабинете | 1. Нажатие кнопки "MyFilms" 2.Нажатие кнопки "Cancel film"                                                 | Обновление фильмов на  странице "MyFilms"                                | Обновление фильмов на странице  "MyFilms"                                 |    Pass   |
|    5    | Возможность  редактирования профиля          | 1. Нажатие кнопки "Profile" 2.Нажатие кнопки "Edit" 3. Внесение изменений 4.Нажатие кнопки "Save changes" | Обновление личной информации  о пользователе                             | Обновление личной информации о  пользователе                              |    Pass   |


## **7. Выводы**
Данный тестовый план позволяет протестировать основной функционал приложения.  
Успешное прохождение всех тестов может свидетельствовать тому, что приложение  
соответствует всем заявленным требованиям и стабильно работает.
