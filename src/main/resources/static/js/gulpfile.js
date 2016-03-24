"use strict";

/**
 * Created by dominik on 24.03.16.
 */

var gulp = require("gulp");
var babel = require("gulp-babel");
var watch = require("gulp-watch");
var tsb = require('gulp-tsb');
var notify = require('gulp-notify');

var tsFiles = ["typings/**/*.ts", "*.ts", "*.ts"];
var jsFiles = ["*.js", "*.js", "!node_modules/**/*.js"];
var compilation = tsb.create({
    target: 'es6',
    module: 'commonjs',
    declaration: false,
    "sourceMap": true,
    "noImplicitAny": false,
    "removeComments": false,
    "preserveConstEnums": false
});

gulp.task("build", function () {
    return gulp.src(tsFiles).pipe(compilation()).pipe(gulp.dest(function (file) {
        return file.base;
    })).pipe(notify({
        title: 'DONE COMPILATION TYPESCRIPT',
        message: 'Compile file  <%= file.relative %>',
        onLast: true,
        notifier: function notifier(args) {}
    }));
});

gulp.task("buildjs", ["build"], function () {
    return gulp.src(jsFiles).pipe(babel({
        presets: ['es2015']
    })).pipe(gulp.dest(function (file) {
        return file.base;
    })).pipe(notify({
        title: 'DONE COMPILATION JAVASCRIPT',
        message: 'Compile file  <%= file.relative %>',
        onLast: true,
        notifier: function notifier(args) {}
    }));
});

gulp.task("compile", ["build", "buildjs"]);

gulp.task("watch", function () {
    gulp.watch(tsFiles, ["compile"]);
});