# [Способы обработки исключений в контроллерах](https://habr.com/ru/articles/528116/)
1) @ExceptionHandler. Такой аннотацией маркируется метод, описываемый в контроллере. Недостаток данного
способа в том, что обработчик не объявляется глобально, так, например, при нескольких контроллерах,
возвращающих одну и ту же ошибку придется копипастить обработчик в каждый из контроллеров. Этого
можно избежать объявлением обработчиков в супер-контроллере, чтобы затем унаследоваться от него, однако появляются сложности с поддержкой в будущем.
2) @HandlerExceptionResolver - не рассматривал данный способ
3) @ControllerAdvice. Такой аннотацией маркируется класс с обработчиками, имеющие аннотацию @ExceptionHandler. В отличие 
от первого способа задает обработчики глобально. Кроме того, можно привязать advice к конкретным контроллерам.

Response.java
````
@Data
@AllArgsConstructor
public class Response {
    private String message;
}
````

PersonAdvice.java
````
   @ControllerAdvice
   public class PersonAdvice {

   @ExceptionHandler(PersonNotFoundException.class)
       public ResponseEntity<Response> handleException(PersonNotFoundException e) {
       Response response = new Response(e.getMessage());
       return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
   }
   }
````

4) @ResponseStatus(HttpStatus.*) + (server.error.include-message=always). Первой аннотацией маркируется исключение с возвращаемым статусом
. Для вывода тела ответа дополнительно прописать в пропертях свойство.

PersonNotFoundException.java
````
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(int id) {
        super("Person not found! id="+id);
    }
}
````
5) throw new ResponseStatusException(HttpStatus.*, message). Такое исключение выбрасывается из контроллера. Может потребовать
написать свойство выше в пропертях для вывода тела ответа.

PersonRestController.java
````
@RestController
@RequestMapping("/persons")
public class PersonRestController {
    private PersonService service;

    @Autowired
    public PersonRestController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/get/{id}")
    public PersonDtoOut getPersonById(@PathVariable(name="id") int id) {
        try {
            return service.getById(id);
        } catch (PersonNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
````