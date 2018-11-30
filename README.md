# ContactService
contact service with CRUD operation

Pagination GET Mapping URL
http://localhost:8083/contact/search?query=&page=1 

To Get All the contacts
http://localhost:8083/contacts

To get contact by passing id 
http://localhost:8083/contact/id/1

To add new contact POST Mapping URL
http://localhost:8083/contact/newContact

To delete contact DELETE Mappping URL
http://localhost:8083/contact/remove/1

To modify contact PUT Mapping URL
http://localhost:8083/contact/modify

OutPut of Pagination  

{
    "content": [
        {
            "id": 1,
            "name": "nick",
            "email": "nick@gmail.com"
        },
        {
            "id": 2,
            "name": "george",
            "email": "george@ymail.com"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "offset": 0,
        "pageSize": 10,
        "pageNumber": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 2,
    "last": true,
    "size": 10,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "numberOfElements": 2,
    "first": true,
    "empty": false
}

/*----------------------------------------------------*/

Displaying all contacts

[
    {
        "id": 2,
        "name": "george",
        "email": "george@ymail.com"
    },
    {
        "id": 4,
        "name": "Ramu",
        "email": null
    }
]

/*----------------------------------------------------*/






