const HtmlWebpackPlugin = require("html-webpack-plugin")
const path = require("path")
const { CleanWebpackPlugin } = require('clean-webpack-plugin')
const CopyPlugin = require("copy-webpack-plugin")

const isProduction = process.env.NODE_ENV === 'production';
const scalaSuffix = isProduction ? "opt" : "fastopt"

module.exports = {
    name: "zioscalajs",
    entry: path.resolve(__dirname, `target/scala-2.13/zioscalajs-${scalaSuffix}/main.js`),
    output: {
        path: path.resolve(__dirname, "build"),
    },
    plugins: [
        new CleanWebpackPlugin({ cleanStaleWebpackAssets: false }),
        new HtmlWebpackPlugin({
            inject: "body",
            template: "public/index.html"
        }),
// Copy assets
//        new CopyPlugin({
//            patterns: [
//                { from: "public/img", to: "img" },
//            ],
//        }),
    ]
}