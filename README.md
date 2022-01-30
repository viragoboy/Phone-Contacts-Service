# Phone-Contacts-Service

Project for my bootcamp

## Purpose of this application
This application is designed to manage phone contacts similar to what is available in a smartphone. The user should be able to create new contacts, update those contacts and delete them. 


### Phone Contacts User Stories

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


### Endpoints for users

| Request Type | URL                | Functionality | Request Body |
|--------------|--------------------|---------------|--------------|
| GET          | /api/user          | Get all users | None         |
| POST         | /api/user/         | Create a user | User object  |
| GET          | /api/user{userid}  | Get a user    | None         |
| PUT          | /api/user/{userid} | Update a user | User object  |
| DELETE       | /api/user/{userid} | Delete a user | None         |
