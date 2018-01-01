## Naming Style

### 1 Rules common to all identifiers[![img](https://google.github.io/styleguide/include/link.png)](https://google.github.io/styleguide/javaguide.html#s5.1-identifier-names)

Identifiers use only ASCII letters and digits, and, in a small number of cases noted below, underscores. Thus each valid identifier name is matched by the regular expression `\w+` .

In Google Style special prefixes or suffixes, like those seen in the examples `name_`, `mName`, `s_name` and `kName`, are **not** used.

### 2 Rules by identifier type[![img](https://google.github.io/styleguide/include/link.png)](https://google.github.io/styleguide/javaguide.html#s5.2-specific-identifier-names)

#### 2.1 Package names[![img](https://google.github.io/styleguide/include/link.png)](https://google.github.io/styleguide/javaguide.html#s5.2.1-package-names)

Package names are all lowercase, with consecutive words simply concatenated together (no underscores). For example, `com.example.deepspace`, not `com.example.deepSpace` or `com.example.deep_space`.

#### 2.2 Class names[![img](https://google.github.io/styleguide/include/link.png)](https://google.github.io/styleguide/javaguide.html#s5.2.2-class-names)

Class names are written in [UpperCamelCase](https://google.github.io/styleguide/javaguide.html#s5.3-camel-case).

Class names are typically nouns or noun phrases. For example, `Character` or `ImmutableList`. Interface names may also be nouns or noun phrases (for example, `List`), but may sometimes be adjectives or adjective phrases instead (for example, `Readable`).

There are no specific rules or even well-established conventions for naming annotation types.

*Test* classes are named starting with the name of the class they are testing, and ending with `Test`. For example, `HashTest` or `HashIntegrationTest`.

#### 2.3 Method names[![img](https://google.github.io/styleguide/include/link.png)](https://google.github.io/styleguide/javaguide.html#s5.2.3-method-names)

Method names are written in [lowerCamelCase](https://google.github.io/styleguide/javaguide.html#s5.3-camel-case).

Method names are typically verbs or verb phrases. For example, `sendMessage` or `stop`.

Underscores may appear in JUnit *test* method names to separate logical components of the name, with *each* component written in [lowerCamelCase](https://google.github.io/styleguide/javaguide.html#s5.3-camel-case). One typical pattern is `*<methodUnderTest>*_*<state>*`, for example `pop_emptyStack`. There is no One Correct Way to name test methods.

#### 2.4 Constant names[![img](https://google.github.io/styleguide/include/link.png)](https://google.github.io/styleguide/javaguide.html#s5.2.4-constant-names)

Constant names use `CONSTANT_CASE`: all uppercase letters, with each word separated from the next by a single underscore. But what *is* a constant, exactly?

Constants are static final fields whose contents are deeply immutable and whose methods have no detectable side effects. This includes primitives, Strings, immutable types, and immutable collections of immutable types. If any of the instance's observable state can change, it is not a constant. Merely *intending* to never mutate the object is not enough. Examples:

```
// Constants
static final int NUMBER = 5;
static final ImmutableList<String> NAMES = ImmutableList.of("Ed", "Ann");
static final ImmutableMap<String, Integer> AGES = ImmutableMap.of("Ed", 35, "Ann", 32);
static final Joiner COMMA_JOINER = Joiner.on(','); // because Joiner is immutable
static final SomeMutableType[] EMPTY_ARRAY = {};
enum SomeEnum { ENUM_CONSTANT }

// Not constants
static String nonFinal = "non-final";
final String nonStatic = "non-static";
static final Set<String> mutableCollection = new HashSet<String>();
static final ImmutableSet<SomeMutableType> mutableElements = ImmutableSet.of(mutable);
static final ImmutableMap<String, SomeMutableType> mutableValues =
    ImmutableMap.of("Ed", mutableInstance, "Ann", mutableInstance2);
static final Logger logger = Logger.getLogger(MyClass.getName());
static final String[] nonEmptyArray = {"these", "can", "change"};
```

These names are typically nouns or noun phrases.

#### 2.5 Non-constant field names[![img](https://google.github.io/styleguide/include/link.png)](https://google.github.io/styleguide/javaguide.html#s5.2.5-non-constant-field-names)

Non-constant field names (static or otherwise) are written in [lowerCamelCase](https://google.github.io/styleguide/javaguide.html#s5.3-camel-case).

These names are typically nouns or noun phrases. For example, `computedValues` or `index`.

#### 2.6 Parameter names[![img](https://google.github.io/styleguide/include/link.png)](https://google.github.io/styleguide/javaguide.html#s5.2.6-parameter-names)

Parameter names are written in [lowerCamelCase](https://google.github.io/styleguide/javaguide.html#s5.3-camel-case).

One-character parameter names in public methods should be avoided.

#### 2.7 Local variable names[![img](https://google.github.io/styleguide/include/link.png)](https://google.github.io/styleguide/javaguide.html#s5.2.7-local-variable-names)

Local variable names are written in [lowerCamelCase](https://google.github.io/styleguide/javaguide.html#s5.3-camel-case).

Even when final and immutable, local variables are not considered to be constants, and should not be styled as constants.

#### 2.8 Type variable names[![img](https://google.github.io/styleguide/include/link.png)](https://google.github.io/styleguide/javaguide.html#s5.2.8-type-variable-names)

Each type variable is named in one of two styles:

- A single capital letter, optionally followed by a single numeral (such as `E`, `T`, `X`, `T2`)
- A name in the form used for classes (see Section 5.2.2, [Class names](https://google.github.io/styleguide/javaguide.html#s5.2.2-class-names)), followed by the capital letter `T` (examples: `RequestT`, `FooBarT`).

### 3 Camel case: defined[![img](https://google.github.io/styleguide/include/link.png)](https://google.github.io/styleguide/javaguide.html#s5.3-camel-case)

Sometimes there is more than one reasonable way to convert an English phrase into camel case, such as when acronyms or unusual constructs like "IPv6" or "iOS" are present. To improve predictability, Google Style specifies the following (nearly) deterministic scheme.

Beginning with the prose form of the name:

1. Convert the phrase to plain ASCII and remove any apostrophes. For example, "Müller's algorithm" might become "Muellers algorithm".

2. Divide this result into words, splitting on spaces and any remaining punctuation (typically hyphens).

   - *Recommended:* if any word already has a conventional camel-case appearance in common usage, split this into its constituent parts (e.g., "AdWords" becomes "ad words"). Note that a word such as "iOS" is not really in camel case *per se*; it defies *any* convention, so this recommendation does not apply.

3. Now lowercase

    

   everything

    

   (including acronyms), then uppercase only the first character of:

   - ... each word, to yield *upper camel case*, or
   - ... each word except the first, to yield *lower camel case*

4. Finally, join all the words into a single identifier.

Note that the casing of the original words is almost entirely disregarded. Examples:

| Prose form              | Correct                             | Incorrect           |
| ----------------------- | ----------------------------------- | ------------------- |
| "XML HTTP request"      | `XmlHttpRequest`                    | `XMLHTTPRequest`    |
| "new customer ID"       | `newCustomerId`                     | `newCustomerID`     |
| "inner stopwatch"       | `innerStopwatch`                    | `innerStopWatch`    |
| "supports IPv6 on iOS?" | `supportsIpv6OnIos`                 | `supportsIPv6OnIOS` |
| "YouTube importer"      | `YouTubeImporter``YoutubeImporter`* |                     |

*Acceptable, but not recommended.

**Note:** Some words are ambiguously hyphenated in the English language: for example "nonempty" and "non-empty" are both correct, so the method names `checkNonempty` and `checkNonEmpty` are likewise both correct.