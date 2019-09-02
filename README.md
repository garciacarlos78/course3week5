# Consideraciones

Aunque se indica que únicamente se guarden en la tabla las últimas 5 mascotas rateadas, se guardan todas.
El motivo es no perder los rates del resto de mascotas. Si hay más de 5 mascotas rateadas, al iniciar
de nuevo la app se perderían todos sus "likes".

Se ha aprovechado la característica ROWID: cuando una tabla no tiene primary key, SQLite asigna automáticamente una columna de uso interno llamada ROWID por la que se puede ordenar.