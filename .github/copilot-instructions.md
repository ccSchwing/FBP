# JSP Project Development Guide

This is a JavaServer Pages (JSP) web application project configured for development and deployment on Apache Tomcat.

## Project Structure

- `src/` - Java source files (servlets, beans, utilities)
- `WebContent/` - Web application root
  - `WEB-INF/` - Configuration and private resources
    - `web.xml` - Deployment descriptor
    - `lib/` - JAR dependencies
  - `css/` - Stylesheets
  - `js/` - JavaScript files
  - `*.jsp` - JSP pages
- `build/` - Compiled classes (generated)
- `dist/` - WAR file (generated)

## Setup and Build

1. Ensure Java JDK 8+ and Tomcat 9+ are installed
2. Build the project using Ant: `ant build`
3. Deploy: `ant deploy` or copy WAR to Tomcat webapps/

## Development

- Edit JSP files in `WebContent/`
- Create servlets in `src/`
- Update `web.xml` for servlet mappings
- Hot reload: Restart Tomcat or use IDE deployment tools

## Testing

- Access the application at `http://localhost:8080/jsp-src`
- Check Tomcat logs for debugging: `$CATALINA_HOME/logs/`
