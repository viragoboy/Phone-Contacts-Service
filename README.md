# Phone-Contacts-Service

Project for my bootcamp

## Purpose of this application
This application is designed to manage phone contacts similar to what is available in a smartphone. The user should be able to create new contacts, update those contacts and delete them. 
This project involved using a REST API for a phone contacts database that allows the user to view a full list of contacts.

## Phone Contacts User Stories
As a user I want to be able to create a new phone contact.

* Given that I want to create a new contact
* When I type the new contact information and send the request to the server
* Then the new contact is saved in the database and I will see it on my contacts list

As a user I want to be able to see all of my contacts information.

* Given that I have existing contact information
* When I request the contact information from the server
* Then all the contacts will be display

As a user I want to be able to update my phone contacts according to any changes regarding their personal information.

* Given that I have existing contact information
* When I want to update contact information and send the request to the server
* Then the updated contact is saved in the database and I will see it on my contacts list

As a user I want to be able to delete a contact not longer needed.

* Given that I have existing contact information
* When I want to delete a contact and send the request to the server
* Then the deleted contact is removed from the database and I will not see it on my contacts list anymore

As a user I want to be able to keep a phone contact list.

## Entity Relationship Diagram (ERD)
![image info](./images/ERD.png)

### Endpoints for User
| Request Type | URL                | Functionality | Request Body |
|--------------|--------------------|---------------|--------------|
| GET          | /api/user          | Get all users | None         |
| POST         | /api/user/         | Create a user | User object  |
| GET          | /api/user/{userId} | Get a user    | None         |
| PUT          | /api/user/{userId} | Update a user | User object  |
| DELETE       | /api/user/{userId} | Delete a user | None         |

### Endpoints for Contact
| Request Type | URL                                    | Functionality       | Request Body   |
|--------------|----------------------------------------|---------------------|----------------|
| GET          | /api/user/{userId}/contact             | Get all contacts    | None           |
| POST         | /api/user/{userId}/contact             | Create a contact    | Contact object |
| GET          | /api/user/{userId}/contact/{contactId} | Get a contact by Id | None           |
| PUT          | /api/user/{userId}/contact/{contactId} | Update a contact    | Contact object |
| DELETE       | /api/user/{userId}/contact/{contactId} | Delete a contact    | None           |

### Endpoints for Address
| Request Type | URL                                                        | Functionality        | Request Body   |
|--------------|------------------------------------------------------------|----------------------|----------------|
| GET          | /api/user/{userId}/contact/{contactId}/address             | Get an address       | None           |
| POST         | /api/user/{userId}/contact/{contactId}/address             | Create an address    | Address object |
| GET          | /api/user/{userId}/contact/{contactId}/address/{addressId} | Get an address by Id | None           |
| PUT          | /api/user/{userId}/contact/{contactId}/address/{addressId} | Update an address    | Address object |
| DELETE       | /api/user/{userId}/contact/{contactId}/address/{addressId} | Delete an address    | None           |

### Endpoints for Phone
| Request Type | URL                                                    | Functionality     | Request Body |
|--------------|--------------------------------------------------------|-------------------|--------------|
| GET          | /api/user/{userId}/contact/{contactId}/phone           | Get all phones    | None         |
| POST         | /api/user/{userId}/contact/{contactId}/phone           | Create a phone    | Phone object |
| GET          | /api/user/{userId}/contact/{contactId}/phone/{phoneId} | Get a phone by Id | None         |
| PUT          | /api/user/{userId}/contact/{contactId}/phone/{phoneId} | Update a phone    | Phone object |
| DELETE       | /api/user/{userId}/contact/{contactId}/phone/{phoneId} | Delete a phone    | None         |

## Sample of data
```
[
    {
        "userId": 1,
        "name": "Tatiana Domingue",
        "contacts": [
            {
                "contactId": 1,
                "name": "Lisa Smith",
                "address": {
                    "addressId": 1,
                    "street": "92 Rock St",
                    "city": "Mountain",
                    "state": "Colorado",
                    "zipCode": 74298
                },
                "phones": [
                    {
                        "phoneId": 1,
                        "type": "mobile",
                        "number": "(498) 921-8758"
                    },
                    {
                        "phoneId": 2,
                        "type": "home",
                        "number": "(478) 521-6532"
                    }
                ]
            }
        ]
    }
]
```