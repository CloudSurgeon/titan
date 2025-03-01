.. _cli_cmd_remote_add:

titan remote add
================

Add a new remote. For more information on managing remotes, see
the :ref:`remote_addremove` section.

Syntax
------

::

    titan remote add [-r remote] <uri> <repository>

Arguments
---------

repository
    *Required*. The name of the target repository.

uri
    *Required*. The remote URI to use. For more information on URI format,
    see the provider sections under the :ref:`remote` section.

Options
-------

-r, --remote remote     Optional remote name. If not provided, then the name
                        'origin' is assumed.

Example
-------

::

    $ titan remote add -r upstream s3://titan-data-demo/hello-world/postgres hello-world
