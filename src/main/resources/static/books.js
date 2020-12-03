var app = angular.module('books', []);

app.controller("BooksController", function ($scope, $http) {

    $scope.getBooks = function () {
        $http.get('/api/books').then(function (response) {
            $scope.booksList = response.data;
            $scope.errormessage = "";
        }, function (error) {
            console.log(error);
            $scope.errormessage = "Unable to get list of books";
        });
    };

    $scope.deleteBook = function (id) {
        $http.delete('/api/books/' + id).then(function () {
            $scope.booksList = $scope.booksList.filter(function (book) {
                return book.id !== id;
            });
            $scope.errormessage = "";
        }, function (error) {
            console.log(error);
            $scope.errormessage = "Unable to delete book";
        });
    };

    $scope.createBook = function () {
        $http.post('/api/books/', {
            title: $scope.title,
            author: $scope.author,
            price: $scope.price
        }).then(function (response) {
            $scope.booksList.push(response.data);
            $scope.errormessage = "";
            $scope.title = "";
            $scope.author = "";
            $scope.price = "";
        }, function (error) {
            console.log(error);
            $scope.errormessage = "Unable to add new book";
        });
    };

});
