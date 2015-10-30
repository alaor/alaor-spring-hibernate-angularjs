angular.module('hello', [])
  .controller('home', function($scope, $http) {

      $scope.remover = function(id) {

          $http.get('/delete?id='+id).success(function(data) {

              console.log('Documento removido com sucesso!');

              $scope.listar();

          });

      };

      $scope.listar = function() {

          $http.get('/list/').success(function(data) {
              $scope.documentos = data;
          });

      };

      $scope.adicionar = function(doc) {

         console.log(doc);

         if (!doc.id || doc.id === 'undefined') {

             console.log('IF!');

            $http.get('/create?titulo=' + doc.titulo + '&codigo=' + doc.codigo + '&texto=' + doc.texto)
                .success(function (data) {

                    console.log('Documento inserido com sucesso!');

                    $scope.iniciarDoc();

                    $scope.listar();

                });

        } else if (doc.id !== 'undefined' || doc.id !== null) {

             console.log('ELSE!');

              $http.get('/update?id='+doc.id+'&titulo=' + doc.titulo + '&codigo=' + doc.codigo + '&texto=' + doc.texto)
                  .success(function (data) {

                      console.log('Documento alterado com sucesso!');

                      $scope.iniciarDoc();

                      $scope.listar();

                  });
        }

      };

      $scope.editar = function(d) {

          $scope.doc = angular.copy(d);

      };

      $scope.iniciarDoc = function(){

          $scope.doc = {
              titulo: '',
              codigo: '',
              texto: ''
          };

      }

      $scope.fecharModalCad = function(){
          $scope.iniciarDoc();
      }

      function init() {

          $scope.iniciarDoc();

          $scope.listar();

          console.log($scope.doc);
      }

      init();

})
