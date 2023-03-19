package com.example.data.common

//// Создание объекта Moshi,
//// для Kotlin необходимо добавлять KotlinJsonAdapterFactory
//val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory()).build()
//// Создание адаптера
//val jsonAdapterRequest = moshi.adapter(SomeClass::class.java)
//// Сериализация, SomeClassInstance - экземляр класса SomeClass
//val jsonRequest = jsonAdapterRequest.toJson(SomeClassInstance)


//Если требуется сериализовать более сложный объект, например коллекцию,
// то тип можно передать двумя способами.

//1) С помощью метода Types.newParameterizedType(), который создает новый параметризованный тип.
//val jsonAdapterRequest = moshi.adapter<List<SomeClass>>(
//    Types.newParameterizedType(List::class.java, SomeClass::class.java)


//2)С помощью класса TypeToken библиотеки Gson. Класс используется для передачи информации
// о типах во время выполнения программы. Конструктор класса возвращает представленный класс
// из заданного типа.
//val jsonAdapterRequest = moshi.adapter<List<SomeClass>>(
//    object : TypeToken<List<SomeClass?>?>(){}.type
//)

//Разница способов состоит в том, что TypeToken более типобезопасен (typesafe),
// а Types.newParameterizedType более эффективен.


//Десериализация осуществляется аналогичным образом:

// Создание адаптера для десериализации
// Используется тот же объект Moshi, что и при сериализации
//val jsonAdapterResponse = moshi.adapter(SomeClass::class.java)
// Десериализация
//val jsonResponse = jsonAdapterResponse.fromJson(receivedData)

//********************************************************************
//рекомендуется оборачивать операции Moshi в блок try-catch.
