Android-Validator
=================

Form Validator Library for Android

Presentation
------------

Form Validator Library for Android a pour base [Zend_Validator](http://framework.zend.com/manual/1.12/en/zend.validate.introduction.html, "Title") codé en PHP. Cette library a pourbut de simplifier et alléger le code pour pouvoir valider un formulaire Android. Pour le moment, le formulaire ne peut traiter que les **EditText**. Les autres éléments verront le jour dans les prochaines versions.

### License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

Utilisation
-----------

Form Validator Library est composé de 3 membres : 
-   **Form :** Contient tous les validates devant êtres traiter. C'est le Form qui gère l'affichage des messages d'erreur au sein des différents éléments.
-   **Validate :** Contient tous les validators devant être traités pour un élement donné.
-   **Validator :** Permet de définir une règle de validation.

### Validator

Le validator contient pour le moment 3 règles de validation basiques :
1.   **EmailValidator**
2.   **NotEmptyValidator**
3.   **UrlValidator**