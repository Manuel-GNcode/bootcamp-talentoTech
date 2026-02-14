#paso 1
**Entensiones obligatorias**
1. Extension pack for java (microsoft)
2. Spring Boot Extension (vmware)
3. Maven for java (microsoft)
##Paso 2
**Crear base de datos**
1. En postgress CREATE DATABASE nombre_db;
##Paso 3
**Crear proyecto con spring boot**
1. ctrl + shift + p
2. maven project
3. spring boot version para este caso (3.5.10)
4. lenguaje (java)
5. dominio (com.nombreEmpresa)
6. nombre-proyecto
7. nombre del paquete (por defecto)
8. jar
9. version java este caso 17
10. dependencias (spring web, spring data jpa sql, postgresSQL driver)
**crear conexión api-bd**
1. en resource -> crear archivo aplication.yml:
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/nombre_db
    username: tu_username
    password: tu_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect

server:
  port: 8080
**Crear entidad**
1. src/main/java/com/tuEmpresa/tuProyecto -> creamos carpeta model -> creamos nueva clase
2. Indicarle: @Entity, @Table(name = "nombre-tabla")
3. Crear Id, @GeneratedValue() y tipo Long
4. Crear las columnas de la tabla o propiedades de la entidad @column()
5. Crear constructor (por defecto vacío)
6. los getters & setters
**Crear el repositorio**
1. src/main/java/com/tuEmpresa/tuProyecto -> creamos carpeta repository -> creamos nueva interface
2. Hacemos que la interface herede de: extends JpaRepository<Entidd, Long>
**Crear controller**
1. src/main/java/com/tuEmpresa/tuProyecto -> creamos carpeta controller -> creamos nueva clase
2. indicamos: @RestController, @RestMapping("/api/users"), @CrossOrigin(origin = "http://localhost:4200"), este último es para permitir que la app en ese puerto pueda modificar la db
3. Declaramos una instancia de repository: private final UserRepository userRepository;
4. Creamos el constructor donde asignamos el valor de userRepository
5. Creamos los métodos @GetMapping(), @PostMapping()...
##Paso 4
**Probar si funciona la api**
1. en apiApplication corremos el server (otra forma: ./mvnw spring-boot:run en cd api)
1. abrimos postman y hacemos los diferentes request
##paso 5 
**Crear Frontend**
1. ng new nombre_proyecto
2. Limpiar lo que no se va a usar, favicon, estilos...
3. en main.ts importar provideHttpClient <-- verificar si ya se crea solo
**Crear service**
1. Creamos un nuevo servicio: ng g s services/nombreService
2. Importamos Injectable, HttpClient, Observable y la interface de la api (opcional, si no usar any)
3. a la clase le damos @Injectable({providedIn: 'root'})
4. Creamos una constante con la Url de la api
5. creamos el constructor donde pedimos: private http: HttpClient
6. creamos un método para cada tipo de petición que necesitamos: obtener todos los usuarios, uno solo...:
**Ejemplos comúnes de peticiones**
  //Get de todos los usuarios
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrl);
  }
  //Get por Id
  getUser(id: number): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}/${id}`);
  }
  //POST - Crear
  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.apiUrl, user);
  }
  //PUT - Actualizar completo
  updateUser(id: number, user: User): Observable<User> {
    return this.http.put<User>(`${this.apiUrl}/${id}`, user);
  }
  //PATCH - Actualizar parcial
  patchUser(id: number, user: Partial<User>): Observable<User> {
    return this.http.patch<User>(`${this.apiUrl}/${id}`, user);
  }
  //DELETE - Eliminar
  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
**Usar el servicio**
1. Creamos un nuevo component: ng g c components/nombreComponent
2. Importamos {Component, OnInit} y los servicios
3. en la clase implementamos OnInit
4. Creamos la variable users: User[] = [];
5. Creamos constructor donde pedimos el servicio
6. creamos el método ngOnInit() <-- método que se ejecuta una vez al cargar el componente
7. creamos método para cargar los usuarios y uno para borrar a modo de prácica
  loadUsers() {
    this.usersService.getUsers().subscribe(data => {
      this.users = data;
    });
  }

  delete(id: number) {
    this.usersService.deleteUser(id).subscribe(() => {
      this.loadUsers();
    });
  }

**Manejo de errores**
1. En service.ts importamos catchError y throwError
2. a los métodos les ponemos:
  .pipe(
    catchError(error => {
      console.error('Error:', error);
      return throwError(() => error);
    })
  );