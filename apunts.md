Dibuix 15:30:
-------------

- La capa de persistència proveeix un ORM, un mapping entre model i DB. Mapejador món OO a món

- JDBC és una interfície única. Una capa d'abstracció. Una especificació: un contracte a complir. Interfícies.

- Només DriverManager no és una interfície.

- Drivers són les implementacions de cada fabricant, que compleixen els contractes. Jar que cal integrar en la nostra app.

- Els mapejadors han d'obtenir llevats com a objectes les entitats que dormen a la BD en taules. O al revés, com els nostres objectes entitats els mapejarem a taules perquè dormin a la BD.

- El nostre codi Java no canviarà si enlloc de connectar-nos a un MySQL, ens volem connectar a un PostgreSQL.



Dibuix JDBC API: 17:53
-----------------------

---
Connecting to a DB:  
1. Obtain the JDBC driver and add it to the CLASSPATH
2. Register the JDBC driver with DriverManager
3. Construct a connection URL
4. Use the getConnection() static method of DriverManager.

---
### Data Access Layer (DAL) o Capa de Persistència.


Dibuix 22:25: Layers
--------------------

> Cal fugir de Data Driven Development: dibuix 23:20

- Packages / mòduls casen amb les capes d'una app empresarial.

1. Entities core: revisar les entitats de negoci -> La capa de negoci és la primera a dissenyar i ha de ser independent de la resta de capes.
2. La capa de presentació haurà d'interactuar amb la capa de negoci per a mostrar les entitats (amb MVC o equivalent).
3. Capa de persistència. DAOs. JDBC / Hibernate / JPA. Driver (tipus de Drivers).

> Des de la capa de negoci interactuarem amb els DAOS (interfícies). Cada interfície DAO tindrà la seva implementació.


Dibuix 56:45
-------------

Un framework ORM com JPA / Hibernate et pot crear les taules a partir de les entitats de negoci (POJOs).

Atributs -> columnes.

> Amb JDBC el programador ha de crear la traducció.

---> Mostrem ara DAO interfícies i classes implementadores.

### SQLException (és una _checked exception_)

Possible error en temps d'execució !!!

Si propaguem la SQLException (MongoException, HibernateException ...) cap a capes superiors perquè sigui mostrada: **la nostra App no serà independent de la tecnologia de persistència usada !!!**

> **Propagarem una DAOException**: és transparent i independent de la tecnologia de persistència.

-> Mostrem ara el paquet d'excepcions.  

-> Totes les interfícies DAO fan un throws DAOException.

-> Mostrem ara les operacions de DAOColor, EventColor, EmployeeColor (minut 1:22:53)

- Paquet contracts exposa a l'exterior (interfícies)
- Paquet impl conté les implementacions internes que no ens interessen.

> A ``1:38:25`` comença la implementació de getColorById()

---
## Segon vídeo

52:30 -> DAOException i totes les sobrecàrregues del constructor.

59:30 -> getEmployees() implementació

1:12:47 -> Stored Procedure

1:14:10 -> 1:21:00 --> CallableStatement demo

### DAOFactory: a partir de 1:33:28 (segon vídeo)

- DAOFactory al paquet persistence.utilities (al mateix nivell que persistence.exceptions i persistence.daos)


