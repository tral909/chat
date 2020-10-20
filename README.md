# Chat

## Setting up mongo

### Get mongo image
`$ docker pull mongo`

### Install mongo cli
`$ sudo apt-get install mongodb-clients`

### Run mongo
For running mongo inside host network (get access from **mongo cli** to running container)

`$ docker run -d --name mon --network host mongo` 

### Stop mongo container
`$ docker stop mon`

Remove container (if you need run mongo (name=mon) container with another arguments)

`$ docker rm mon`

##  Manage mongo db

### Connect to mongo db via cmd
`$ mongo`

### Commands
* Show All objects:

    `show dbs (collections, users, roles)`

* Select Database to Work With:

    `use databaseName`

* Show current db:

    `db`

* Create a Collection:

    `db.createCollection('collectionName')`

* Insert a Document in a Collection:

    single doc
    
    `db.collectionName.insert({field1: 'val1'})`

    multiple docs
    
    `db.collectionName.insert([{field1: 'val1'}, {field2: 'val2'}])`

* Save or Update Document:

    `db.collectionName.save({'_id': new ObjectId('jhgsdjhgdsf'), field1: 'value', field2: 'value'})`

* Display Collection Records:

    Retrieve all records
    
    `db.collectionName.find()`

     Retrieve limited number of records
    
    `db.collectionName.find().limit(10)`

    By id
    
    `db.collectionName.find({'_id': ObjectId('someId')})`
    
    Collection count
    
    `db.collectionName.count()`
    