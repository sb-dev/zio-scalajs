# Simple ZIO ScalaJS Skeleton

Here's an app skeleton that brings together the following frameworks:
* [SBT](https://www.scala-sbt.org/)
* [ZIO](https://zio.dev/)
* [ZIO Test](https://zio.dev/)
* [ScalaJS](https://www.scala-js.org/)
* [NPM](https://www.npmjs.com/)
* [Webpack](http://webpack.github.io/)

## Features:
* Code hotswapping
* Static server

## Scripts

### `npm install`

Install Dependencies.

### `npm test`

Run unit tests.

### `npm run build:dev`

Compile the app for development.

### `npm start`

Serves all HTML/JS/CSS and watches all changes to `build/*.js`.  

Note: UI is running at [http://0.0.0.0:8080//](http://0.0.0.0:8080/).

### `npm run build`

Compile the app and make it ready for production deployment.

## Directory Structure

    .
    ├── node_modules
    ├── project
    ├── public
    ├── src
    ├── LICENSE
    ├── .scalafmt.conf
    ├── build.sbt
    ├── package-lock.json
    ├── package.json
    ├── sbt
    ├── webpack.config.js
    └── README.md

1.  **`node_modules/`**: Contains all Nodejs modules.
2.  **`project/`**: Defines Scala build properties.
3.  **`public/`**: Contains index.html template.
4. **`LICENSE`**: MIT License.
5. **`.scalafmt.conf`**: Code formatter config for Scala.
6. **`build.sbt`**: Defines Scala build.
7. **`package-lock.json`**: MIT License.
8. **`package.json`** - Configures JS dependencies and scripts.
9. **`sbt`** - SBT runner.
10. **`webpack.config.js`** - Bundles JS and builds index.html.

## JS Facades

### Global libraries

Add the CDN script to `public/index.html`:

Example using JQuery library:
```html
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
```

```scala
@js.native
@JSGlobal("jQuery")
object JQuery extends js.Object {
  def apply(x: String): JQuery = js.native
}
```

### NPM module

Example using MomentJS:
```shell
npm i moment
```

```scala
@js.native
trait Moment extends js.Object {
  def apply(): Moment = js.native
}

@js.native
@JSImport("moment", "moment")
object Moment extends Moment
```
