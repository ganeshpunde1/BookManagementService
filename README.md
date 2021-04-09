# Book Management Service

### Different Annotation used in Book Management REST API

For further reference, please consider the following sections:

* [@RestController](@RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody annotations, and as a result, simplifies the controller implementation.)
* [@RequestMapping("https://www.baeldung.com/spring-requestmapping)
* [@Autowired](https://www.baeldung.com/spring-autowire)
* [@GetMapping](https://zetcode.com/spring/getmapping/)
* [@GetMapping("/{id}")](https://zetcode.com/spring/getmapping/)

* [@PostMapping](https://howtodoinjava.com/spring5/webmvc/controller-getmapping-postmapping/)
* [@PathVariable](https://www.baeldung.com/spring-pathvariable)
* [@RequestBody User user](https://www.baeldung.com/spring-request-response-body)

* [@DeleteMapping("/{id}")](https://zetcode.com/spring/deletemapping/)
* [@PathVariable ("id") long userId](https://www.baeldung.com/spring-pathvariable)
* [@Repository](https://www.journaldev.com/21460/spring-repository-annotation)
* [@PathVariable ("id") long userId](https://www.baeldung.com/spring-pathvariable)

2)Spring Boot Rest API Validation with Hibernate Validator

In this example, we will create a Spring Boot REST application to show how we can validate a JSON payload sent in an HTTP request
 by adding constraints to the JPA entity. If the data passes validation, it will be persisted to a data store.
  Otherwise, one or more error messages will be returned to the client. We will also demonstrate how to create a custom constraint 
  and how to validate path variables and method return values. Let’s start by creating the Spring Boot application.

Below are some constraints defined by Java Bean Validation API:

@NotEmpty: specifies that the annotated field must not be null or empty.
@NotBlank: the annotated field must not be null and must contain at least one non-whitespace character.
@NotNull: the annotated field must not be null.
@Email: the string has to be a well-formed email address.
@Min: the field must be a number whose value must be higher or equal to the specified minimum value.
@Max: the field must be a number whose value must be lower or equal to the specified maximum value.
@Size: the field must have size falls within the specified range. Applied for string, collections and arrays.


Example :1

public class Book  {
	@NotNull(message = "Book Name cannot be null")
	@Size(min = 2, message = "Book Name should have atleast 2 characters")
	@Column(name = "book_Name")
	private String bookName;

	@NotNull(message = "subject cannot be null")
	@Column(name = "subject")
	@Size(min = 2, message = "subject should have atleast 2 characters")
	private String subject;

	@NotNull
	@Column(name = "book_author")
	private String bookAuthor;

	@NotNull
	@Column(name = "book_code")
	private String bookCd;

	@NotNull
	@Column(name = "price")
	private long price;

	@Email(message = "Email should be valid")
	@Column(name = "email")
	private String email;
	
	...
	}
	
Example :2

public class User {
     
    @NotEmpty(message = "First name is required")
    private String firstName;
      
    @NotEmpty(message = "Last name is required")
    private String lastName;
      
    @NotEmpty(message = "Email is required")
    @Email
    private String email;
     
    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
             message="Mobile number is invalid")
    private String mobilePhone;
     
     @NotNull
     @Size(min=2, max=30)
     private String description;

	@NotNull
	@Min(18)
	private Integer age;
	
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
     
    @NotEmpty(message = "Communication preference is required")
    private String commPreference;
    
     @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthday;

	@NotEmpty(message = "You must enter a credit card number.")
	@Pattern(regexp = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7]"
	                + "[0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}"
	                + "|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])"
	                + "[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$",
	           message = "Invalid card number.")
	private String creditCard;
  }
  
  * [ Bean Validation Cheat Sheet](https://cheatsheetseries.owasp.org/cheatsheets/Bean_Validation_Cheat_Sheet.html)
  
 
