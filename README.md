Strabon
=======

Introduction
------------
Strabon is a fully implemented semantic geospatial database system that can be
used to store linked geospatial data expressed in RDF and query them using an
extension of SPARQL. Strabon supports spatial selections, spatial joins, a rich
set of spatial functions similar to those offered by geospatial relational
database systems, support for multiple Coordinate Reference Systems and widely
used serializations for geometric objects such as WKT and GML. Strabon is built
on top of the well-known RDF store Sesame and extends Sesame’s components to be
able to manage thematic and spatial data that are stored in PostGIS.

The development of Strabon started in the context of European FP7 project
SemsorGrid4Env (Semantic Sensor Grids for Rapid Application Development for 
Environmental Management) [http://www.semsorgrid4env.eu/]. Starting September
2011, Strabon is being utilized and extended with new functionalities in the
FP7 project TELEIOS (Virtual Observatory Infrastructure for Earth Observation
Data) [http://www.earthobservatory.eu/] which our group leads.

The query language of Strabon is called stSPARQL. stSPARQL can be used to query
data represented in an extension of RDF called stRDF. stRDF and stSPARQL have
been designed for representing and querying geospatial data that changes over
time (e.g., the growth of a city over the years due to new developments). 

Currently, only the geospatial features of stSPARQL have been implemented fully.
The temporal features are the subject of current work.

Given the very close relationship between stSPARQL and GeoSPARQL which is a 
recent OGC standard for an extension of SPARQL for querying geospatial metadata,
we recently provided support for the Core, Geometry and Geometry Topology 
extension of GeoSPARQL. 


Conformance to GeoSPARQL
------------------------
Strabon implements the `Core', the `Topology Vocabulary Extension', the
`Geometry Extension', the `Geometry Topology Extension', and the `RDFS Entailment
Extension' except for Req. 25
(http://www.opengis.net/spec/geosparql/1.0/req/rdfs-entailment-extension/bgp-rdfs-ent).

With respect to GML, Strabon supports the GML Profile corresponding to Simple
Features, that is, GML Simple Features Profile 2.0. 


Strabon Homepage
----------------
The homepage of Strabon is at http://www.strabon.di.uoa.gr/.


Demo
----
You can find a demo of the system Strabon at http://test.strabon.di.uoa.gr/NOA/.


How to build and run Strabon from command line
----------------------------------------------
Assuming you have already downloaded Strabon and you are in the top-level
directory of Strabon, issue the following command to build it from command line:

	$ mvn clean package

In order to run automatically the JUnit tests, pass the option `-DskipTests=false' 
to the above command. The complete command is the following:

	$ mvn -DskipTests=false clean package

Alternatively, it is possible to run a specific test. Supposing that the name of
the corresponding class is `TestName', then you can run only this
test using the following command:

	$ mvn test -DfailIfNoTests=false -DskipTests=false -Dtest=TestName

In case of an error during building of Strabon and assuming that the error does
not come from the JUnit tests, please have a look at the `Known Issues' section
below. If none of the known issues of that section applies, please contact the
developers through the Strabon mailing-list or submit a corresponding bug
(see `Bugs' section below).

After you have successfully built Strabon, you have access to the following
components:

  * Strabon Endpoint

    This is a SPARQL endpoint for Strabon. It is distributed as a war file so
    you may deploy it in a Tomcat container. You may find the war file under
    directory `endpoint/target'.

  * Strabon Endpoint (standalone)

    This is a SPARQL endpoint for Strabon like the above one, but it differs
    only in that it does not require the user to have already set up a Tomcat
    container. The standalone Strabon Endpoint may be run by issuing the
    following command:

    	$ java -jar endpoint-exec/target/strabon-endpoint-executable-${version}.jar

    After issuing the above command, you may access the Strabon Endpoint at
    the following URL: <http://localhost:8080/>.

    Please see the page at <http://hg.strabon.di.uoa.gr/Strabon/rev/674f8f91162b>
    to find out other options that you may pass to the Tomcat container that
    will run by the above command.

    SPECIAL NOTE: if you need to configure the connection details to the
    underlying database, you may do so in two ways:
      1. By modifying file `endpoint/WebContent/WEB-INF/connection.properties'
         before building Strabon and executing the above command.
      2. After executing the above command, by visiting the following page by a
         browser: <http://localhost:8080/ChangeConnection>

  * Strabon Endpoint Client

    This is a Java client for interacting with Strabon Endpoint or any other
    SPARQL endpoint. It is packaged as a jar file and may be found under
    directory `endpoint-client/target/' with name
    `strabon-endpoint-client-${version}.jar'. This jar contains any dependencies
    to other code, so may copy and paste it to your project and start playing
    with the code immediately.

  * Strabon script

    The `strabon' script is located under the `scripts/' directory and it is the
    main command-line tool for interacting with Strabon. You may use it to store
    RDF data with geospatial information or query/update it using one of
    stSPARQL or GeoSPARQL query languages.

  * Endpoint script

    The `endpoint' script is located under the `scripts' directory and it is the
    main command-line tool for interacting with a `Strabon Endpoint'. You may
    use it to do any operation you would like to do with the `strabon' script
    above, but in contrast to the `strabon' script you need to have access to a
    Strabon endpoint. Of course, the `Strabon Endpoint Client' component above
    can be used as well as a command-line tool. At the time of writing, the
    `Strabon Endpoint Client' component supports only querying of RDF data with
    geospatial information.


Getting Started
---------------
To get started  with Strabon please have a look at the tutorial for the stRDF
data model and stSPARQL query language, the User Guide, and the Developer Guide.

stRDF and stSPARQL tutorial
	http://www.strabon.di.uoa.gr/files/stSPARQL_tutorial.pdf


### stSPARQL Reference

The reference for the spatial and temporal extension functions defined in 
stSPARQL can be found at http://www.strabon.di.uoa.gr/stSPARQL#spatial and
http://www.strabon.di.uoa.gr/stSPARQL#temporals respectively.


### User Guide

Assuming that you are familiar with Maven, the following steps need to be
followed in order to use Strabon using Eclipse:

1. Install PostgreSQL from http://www.postgresql.org/download/. At the time of
   this writing the latest PostgreSQL version is 9.1.
2. Install PostGIS from http://postgis.refractions.net/download/. At the time of
   this writing we have tested Strabon with PostGIS 1.5.3.
3. Install Maven from http://maven.apache.org/download.html. At the time of this
   writing the latest Maven version is 3.0.4. 
4. Install Eclipse from http://www.eclipse.org/downloads/. At the time of this
   writing the latest Eclipse version is 3.7.2.
5. Install the m2e plugin for Eclipse from http://www.eclipse.org/m2e/.
6. Install the MercurialEclipse plugin for Eclipse from
   http://javaforge.com/project/HGE .
7. From Eclipse, go to File --> Import --> Mercurial --> Clone Existing
   Mercurial Repository --> Next. In the URL textarea paste the following
   URL: http://hg.strabon.di.uoa.gr/StrabonUser and then press Next --> Next -->
   Finish. If you used the default settings, you should have a new project named
   StrabonMain. Right click on the project and select Configure --> Convert to
   Maven project. Eclipse will enable Maven dependency management for the
   project, download any dependencies and build the project. 


#### Storing stRDF graphs and evaluating stSPARQL queries

You can see some examples in the classes gr.uoa.di.strabon.example.PostgisExample
and gr.uoa.di.strabon.example.PostgisExample2.

#### Tuning PostgreSQL

The default settings of Postgres are rather conservative. As a result, parameter 
tuning is neccessary for speeding up Postgres, therefore Strabon. If you are 
using Strabon to compare its performance against your implementation of 
stSPARQL/GeoSPARQL, you are *strongly* encouraged to contact us using the Strabon
Users mailing list for assistance on tuning Postgres.

You can follow the instructions below for tuning a Postgres server running on an 
Ubuntu machine that is dedicated to PostgreSQL and Strabon.

1. Append the following text at the end of postgresql.conf. 
*Uncomment* the appropriate lines.
```
### RAM
## 4 GB of RAM
#shared_buffers       =  3GB
#effective_cache_size =  3GB
#maintenance_work_mem =  1GB
#work_mem             =  2GB
## 8 GB of RAM
#shared_buffers       =  5GB
#effective_cache_size =  6GB
#maintenance_work_mem =  2GB
#work_mem             =  5GB
## 16 GB of RAM
#shared_buffers       = 10GB
#effective_cache_size = 14GB
#maintenance_work_mem =  4GB
#work_mem             = 10GB
## 24 GB of RAM
#shared_buffers       = 16GB
#effective_cache_size = 22GB
#maintenance_work_mem =  6GB
#work_mem             = 15GB
## 48 GB of RAM
#shared_buffers       = 32GB
#effective_cache_size = 46GB
#maintenance_work_mem =  8GB
#work_mem             = 30GB
## 64 GB of RAM
# contact us to find out!
### HD
## RAID with ordinary 7.200 disks
#random_page_cost = 3.5 #3.0-3.5
## High-End NAS/SAN
#random_page_cost = 2 #1.5-2.5
## Amazon EBS/Heroku
#random_page_cost = 1.3 #1.1-2.0
## SSD array
#random_page_cost = 2.0 #1.5-2.5
### Planner options
# Increase the following values in order to avoid using the GEQO planner.
# Small values (<8) reduce planning time but may produce inferior query plans
#
geqo_threshold = 15 # keep this value larger that the following two parameters
from_collapse_limit = 14
join_collapse_limit = 14
### Misc
default_statistics_target    = 10000 
constraint_exclusion         = on 
checkpoint_completion_target = 0.9 
wal_buffers                  = 32MB 
checkpoint_segments          = 64 
### Connections
max_connections              = 10
````
2. Append the following lines at the end of /etc/sysctl.conf
*Uncomment* the appropriate lines.
```
## 4 GB of RAM
#kernel.shmmax = 3758096384
#kernel.shmall = 3758096384
#kernel.shmmni = 4096
## 8 GB of RAM
#kernel.shmmax = 5905580032
#kernel.shmall = 5905580032
#kernel.shmmni = 4096
## 16 GB of RAM
#kernel.shmmax = 11274289152
#kernel.shmall = 11274289152
#kernel.shmmni = 4096
## 24 GB of RAM
#kernel.shmmax = 17716740096
#kernel.shmall = 17716740096
#kernel.shmmni = 4096
## 48 GB of RAM
#kernel.shmmax = 35433480192
#kernel.shmall = 35433480192
#kernel.shmmni = 4224
## 64 GB of RAM
# contact us to find out!
```
3. Apply all changes by executing

$ sudo sysctl -p
$ sudo /etc/init.d/postgresql restart

4. Prepare for the next run by issuing the command 

$ sudo -u postgres psql -c 'VACUUM ANALYZE;' db

or 

$ psql -c 'VACUUM ANALYZE;' db

where db is the name of the Postgres database that Strabon will use.


### Developer Guide

Assuming that you are familiar with Maven, the following steps need to be
followed in order to use Strabon using Eclipse:

1. Install PostgreSQL from http://www.postgresql.org/download/. At the time of
   this writing the latest PostgreSQL version is 9.1.
2. Install PostGIS from http://postgis.refractions.net/download/. At the time of
   this writing we have tested Strabon with PostGIS 1.5.3.
3. Install Maven from http://maven.apache.org/download.html. At the time of this
   writing the latest Maven version is 3.0.4. 
4. Install Eclipse from http://www.eclipse.org/downloads/. At the time of this
   writing the latest Eclipse version is 3.7.2.
5. Install the m2e plugin for Eclipse from http://www.eclipse.org/m2e/.
6. Install the MercurialEclipse plugin for Eclipse from
   http://javaforge.com/project/HGE.
7. From Eclipse, go to File --> Import --> Mercurial --> Clone Existing
   Mercurial Repository --> Next. In the URL textarea paste the following
   URL: http://hg.strabon.di.uoa.gr/Strabon and then press Next --> Next -->
   Finish. If you used the default settings, you should have a new project named
   StrabonMain. Right click on the project and select Configure --> Convert to
   Maven project. Eclipse will enable Maven dependency management for the
   project, download any dependencies and build the project. 


### Tester Guide

Assuming again that you are familiar with Maven and Junit these are the steps
you need to follow to test the functionality of Strabon:


* Using Eclipse

	If you want to create a new test:

	1. Import Strabon into Eclipse as explained in the Developer Guide.
	2. Go to strabon-testsuite project.
	3. Create a new folder (Recommended folder name: <test's name>) and place inside the following files:
	  1. An ntriples or nquads file with the test dataset (with .nt or .nq extension).
	  2. Pairs of files with sparql test queries and expected test results in xml format.
	     Notice that each pair must have the same name and .rq extension for the queryFile and .srx extension for the resultsFile.
	4. Create a test class that extends TemplateTest class.
	5. If you have followed the recommendations the test is ready. If you have different names or location for your
	files, insert them explicitly in the constructor of the class. WARNING: All prefixes must be placed in file "prefixes" so that
	every time a namespace changes, we have to change it just once.
	
	If you want to run a test:
	
	1. Right-click on the test class.
	2. Select "Run as JUnit Test".
	3. Database properties are retrieved from database.properties file. If you want, you can change a property
	"on the fly" with an environment variable.

	
* Command Line
	
	If you want to run all the tests:
	
	1. Go to Strabon directory (root directory of all the subprojects).
	2. Run "mvn test -DskipTests=false".
	3. Optionally you can pass an environment variable with "-DvariableName=variableValue".


#### Storing stRDF graphs and evaluating stSPARQL queries

You can see some examples in the classes
eu.earthobservatory.runtime.postgis.StoreOp and
eu.earthobservatory.runtime.postgis.QueryOp.


Download
--------
You can download the source code of the latest version of Strabon by accessing
our public mercurial repository located at http://hg.strabon.di.uoa.gr/Strabon.
You can find more information on how to use and extend Strabon at the Getting
Started section.


Publications
------------
You can learn about stRDF data model and stSPARQL query language employed in
Strabon by reading our tutorial under the Getting Started section and/or the
publications given on this page. 

The current versions of stRDF and stSPARQL which are based on OGC standards are
presented in the following document:
  * K. Kyzirakos, M. Karpathiotakis, and M. Koubarakis. Strabon: A Semantic 
    Geospatial DBMS. In Internatioanl Semantic Web Conference (ISWC'12). Boston,
    USA, November 11-15, 2012.
    [pdf: http://strabon.di.uoa.gr/files/strabon-iswc.pdf]

  * Manolis Koubarakis, Kostis Kyzirakos, Babis Nikolaou, Michael Sioutis, and
    Stavros Vassos. A data model and query language for an extension of RDF with
    time and space. Deliverable D2.1, European ICT project TELEIOS, 2011.
    [pdf: http://strabon.di.uoa.gr/files/deliv2-1-re-revised.pdf]

The initial versions of stRDF and stSPARQL that are based on constraint
databases are presented in the following publications:
  * Manolis Koubarakis and Kostis Kyzirakos. Modeling and Querying Metadata in
    the Semantic Sensor Web: the Model stRDF and the Query Language stSPARQL.
    In 7th Extended Semantic Web Conference (ESWC 2010). Heraklion, Crete,
    30 May - 03 June, 2010.
    [pdf: http://strabon.di.uoa.gr/files/stSPARQL.pdf]
 
  * Kostis Kyzirakos, Manos Karpathiotakis and Manolis Koubarakis. Developing
    Registries for the Semantic Sensor Web using stRDF and stSPARQL (short
    paper).
    In Proceedings of 3rd International workshop on Semantic Sensor Networks
    2010, in conjunction with ISWC 2010, November 2010, Shanghai, China.
    [pdf: http://strabon.di.uoa.gr/files/strabon.pdf]

Applications of stRDF, stSPARQL, and the system Strabon are described here:
  * Alasdair J. G. Gray, Raúl García-Castro, Kostis Kyzirakos, Manos
    Karpathiotakis, Jean-Paul Calbimonte, Kevin Page, Jason Sadler, Alex
    Frazer, Ixent Galpin, Alvaro A. A. Fernandes, Norman W. Paton, Oscar
    Corcho, Manolis Koubarakis, David De Roure, Kirk Martinez and Asunción
    Gómez-Pérez. A Semantically Enabled Service Architecture for Mashups over
    Streaming and Stored Data. In 8th Extended Semantic Web Conference (ESWC
    2011). Heraklion, Crete, May 20 - June 2, 2011.
    [pdf: http://strabon.di.uoa.gr/files/Gray2011Architecture.pdf]

  * A.J.G. Gray, J. Sadler, O. Kit, K. Kyzirakos, M. Karpathiotakis, J.-P.
    Calbimonte, K. Page, R. García-Castro, A. Frazer, I. Galpin, A.A.A.
    Fernandes, N.W. Paton, O. Corcho, M. Koubarakis, D.D. Roure, K. Martinez,
    A. Gómez-Pérez. A Semantic Sensor Web for Environmental Decision Support
    Applications. Sensors. 11, 8855-8887.
    [pdf: http://strabon.di.uoa.gr/files/sensors-11-08855.pdf]

Coming up soon:
Strabon will soon support an extension of RDF for incomplete geospatial 
information. The following publication gives a preview of the relevant research
problems:
  * M. Koubarakis, K. Kyzirakos, M. Karpathiotakis, C. Nikolaou, M. Sioutis,
    S. Vassos, D. Michail, T. Herekakis, C. Kontoes and I. Papoutsis. Challenges
    for Qualitative Spatial Reasoning in Linked Geospatial Data. In Proceedings
    of IJCAI 2011 Workshop on Benchmarks and Applications of Spatial Reasoning,
    Barcelona, Spain.
    [pdf: http://www.earthobservatory.eu/publications/SciQL_ADASS2011.pdf]

  * C. Nikolaou and M. Koubarakis: "Querying Linked Geospatial Data with
    Incomplete Information". In 5th International Terra Cognita Workshop - 
    Foundations, Technologies and Applications of the Geospatial Web. In
    conjunction with the 11th International Semantic Web Conference, Boston,
    USA, November, 2012.
    [http://www.earthobservatory.eu/publications/iswc-workshop.pdf]


Contributors
------------
The system Strabon has been developed by the following members of our team:

* Manos Karpathiotakis	<mk@di.uoa.gr>
* Kostis Kyzirakos	<Kostis.Kyzirakos@cwi.nl>
* Manolis Koubarakis	<koubarak@di.uoa.gr>
* Giorgos Garbis	<ggarbis@di.uoa.gr>
* Konstantina Bereta	<konstantina.bereta@di.uoa.gr>
* Charalampos Nikolaou	<charnik@di.uoa.gr>
* Stella Gianakopoulou	<sgian@di.uoa.gr>
* Panayiotis Smeros	<psmeros@di.uoa.gr>
* Kallirroi Dogani	<kallirroi@di.uoa.gr>


Mailing-list
------------
Currently, we maintain the following mailing lists:

* Strabon-users, is used as a communication channel for Strabon users.
To subscribe to the mailing-list, please visit page 
http://cgi.di.uoa.gr/~mailman/listinfo/strabon-users. To post e-mails
to Strabon-users mailing-list, write to strabon-users@di.uoa.gr.

* Strabon-devel, is used as a communication channel with the developers
of Strabon. To subscribe to the mailing-list, please visit page 
http://cgi.di.uoa.gr/~mailman/listinfo/strabon-devel. To post e-mails
to Strabon-devel mailing-list, write to strabon-devel@di.uoa.gr.


Bugs
----
Please report bugs to http://bug.strabon.di.uoa.gr/report or
the Strabon-devel mailing-list Strabon-devel@di.uoa.gr.


Known Issues
------------
 * By default, Tomcat uses ISO-8859-1 character encoding when decoding URLs received 
   from a browser. This can cause problems when encoding is UTF-8, and you are using 
   international characters. In order to fix this, edit conf/server.xml and find the 
   line where the Connector is defined. Add the parameter URIEncoding and set it to 
   UTF-8. For example:

   <Connector port="8080" protocol="HTTP/1.1" 
                  connectionTimeout="20000" 
                  URIEncoding="UTF-8"
                  redirectPort="8443" />

 * Building and executing any maven goals fails for maven versions <3.0 due to a
   dependency to the 'shade' plugin that is available only for maven version 3.0
   (http://maven.apache.org/plugins/maven-shade-plugin/). In such systems, you may
   disable execution of this plugin by setting the environmental variable
   `shade.skip'. For example, to build Strabon using maven version 2.0 you may
   execute the following command:

   	$ mvn clean package -Dshade.skip

 * When using MonetDB as a backend, the following source code of MonetDB must be 
   used:
	https://hg.strabon.di.uoa.gr/MonetDB/   


License
-------
This Source Code Form is subject to the terms of the Mozilla Public
License, v. 2.0. If a copy of the MPL was not distributed with this
file, You can obtain one at http://mozilla.org/MPL/2.0/.

Copyright (C) 2010, 2011, 2012, Pyravlos Team

http://www.strabon.di.uoa.gr/


How to apply the license
------------------------
 * In the beginning of script files (after the shell directive) paste the
   following statement:
```
#
# This Source Code Form is subject to the terms of the Mozilla Public
# License, v. 2.0. If a copy of the MPL was not distributed with this
# file, You can obtain one at http://mozilla.org/MPL/2.0/.
#
# Copyright (C) 2010, 2011, 2012, Pyravlos Team
#
# http://www.strabon.di.uoa.gr/
#
```
 * In the beginning of Java source code files paste the following statement:
```
/**
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Copyright (C) 2010, 2011, 2012, Pyravlos Team
 *
 * http://www.strabon.di.uoa.gr/
 */
```
 * In the beginning of HTML/XML files paste the following statement:
```
<!-- This Source Code Form is subject to the terms of the Mozilla Public
   - License, v. 2.0. If a copy of the MPL was not distributed with this
   - file, You can obtain one at http://mozilla.org/MPL/2.0/.
   -
   - Copyright (C) 2010, 2011, 2012, Pyravlos Team
   -
   - http://www.strabon.di.uoa.gr/
-->
```
