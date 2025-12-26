# FBP
FBP Source

# JSP Web Application

A JavaServer Pages (JSP) web application project template for building dynamic web applications.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Tomcat 9 or higher
- Apache Ant (for building)
- VS Code with Java extensions

## Project Structure

```
jsp-src/
├── src/                           # Java source code (servlets, beans)
├── WebContent/                    # Web application root
│   ├── WEB-INF/
│   │   ├── web.xml               # Deployment descriptor
│   │   └── lib/                  # JAR dependencies
│   ├── css/                      # Stylesheets
│   ├── js/                       # JavaScript files
│   ├── index.jsp                 # Home page
│   └── sample.jsp                # Sample JSP page
├── build/                        # Compiled classes (generated)
├── dist/                         # Packaged WAR file (generated)
├── build.xml                     # Ant build script
└── README.md                     # This file
```

## Getting Started

### 1. Build the Project

```bash
ant build
```

This will compile Java sources and create a WAR file in the `dist/` directory.

### 2. Deploy to Tomcat

```bash
ant deploy
```

Or manually copy `dist/jsp-src.war` to `$CATALINA_HOME/webapps/`

### 3. Start Tomcat

```bash
$CATALINA_HOME/bin/startup.sh
```

### 4. Access the Application

Open your browser and navigate to: `http://localhost:8080/jsp-src`

## Development

### Adding a New JSP Page

1. Create a new file in `WebContent/` with `.jsp` extension
2. Use JSP syntax with HTML markup
3. The file will be automatically available after Tomcat restart

### Creating a New Servlet

1. Create a Java class in `src/` extending `HttpServlet`
2. Implement `doGet()` and/or `doPost()` methods
3. Add servlet mapping to `WebContent/WEB-INF/web.xml`
4. Rebuild and redeploy

### Example Servlet Mapping

```xml
<servlet>
    <servlet-name>HelloServlet</servlet-name>
    <servlet-class>com.example.HelloServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>HelloServlet</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>
```

## Useful Ant Targets

- `ant build` - Compile and package the application
- `ant deploy` - Deploy WAR to Tomcat
- `ant clean` - Remove build artifacts
- `ant rebuild` - Clean and rebuild

## Troubleshooting

### Application not accessible

- Check if Tomcat is running: `ps aux | grep tomcat`
- Verify WAR file in `$CATALINA_HOME/webapps/`
- Check Tomcat logs: `$CATALINA_HOME/logs/catalina.out`

### Compilation errors

- Verify JDK version: `javac -version`
- Check `build.xml` for correct classpath
- Ensure Tomcat libraries are in the classpath

## Resources

- [Apache JSP Documentation](https://tomcat.apache.org/tomcat-9.0-doc/jsp-howto.html)
- [Servlet API Documentation](https://docs.oracle.com/javaee/7/api/index.html)
- [Apache Tomcat Documentation](https://tomcat.apache.org/)

## License

Open source - feel free to use and modify as needed.
