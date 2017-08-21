# OAuth2-Authorization-Code

## Authorization Server

Untuk menjalankan Auth Server :

* Akses Folder Auth-Server
* Jalankan dengan perintah : `gradle bootRun`
* Server akan jalan di port 8080

Untuk Melakukan Authentication :

* Akses URL berikut melalui browser
```
http://localhost:8080/oauth/authorize?client_id=clientid&response_type=code&redirect_uri=http://127.0.0.1:8081
```
* Nantinya anda akan diminta untuk login, silahkan isikan dengan : 
user : rizki
pass : mufrizal

* Lalu silahkan approve maka akan redirect ke halaman `http://127.0.0.1:8081/?code=UcZRx8`
* ambil code tersebut lalu akses melalui curl seperti berikut.

```
curl -X POST -vu clientid:secret http://localhost:8080/oauth/token -H "Accept: application/json" -d "grant_type=authorization_code&code=UcZRx8&redirect_uri=http://127.0.0.1:8081"
```
* Jika berhasil maka akan muncul token seperti berikut :
```
{
  "access_token" : "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiUkVTT1VSQ0VfSURfQkFSQU5HIl0sInVzZXJfbmFtZSI6InJpemtpIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTUwMzI5MzMxMywiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiIsIlJPTEVfVVNFUiJdLCJqdGkiOiJkODc1MzczMS0wNDY2LTQ2YTAtODU1MC1kODlmNzY4YjNkYjEiLCJjbGllbnRfaWQiOiJjbGllbnRpZCJ9.jSRI2zjn9Mqn5Hlot8IpO4Q_-z_wa7dqmu0aSr_dBaNE-sljNtGGV4jUNw6LNtguf-GkhZ7NQr4x8vBPp7n5kSsmk7pTHFvXiixHXBFJ-QVPCgz2WvpLRsJFsFaRrGr17AYMChYn_FA_lwB5HrJIMnX-hSKUyrxqMJbq3KxK5JrfE5eTb8wY5bc-qN30SlREAzHV__UALwROcOIJS4qVHqZYN3JqdniIVobDzDK2y-cUYQYiZLm8eLPnNKZqGT5_qNTYTV8EsjpTRXAtVpTTIADRCkWU5VQaPM7Ndyf_JggDxhXe20BnzzZH2att8m3XKBebJLv0w7G5kLLpfI-j8w",
  "token_type" : "bearer",
  "refresh_token" : "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiUkVTT1VSQ0VfSURfQkFSQU5HIl0sInVzZXJfbmFtZSI6InJpemtpIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImF0aSI6ImQ4NzUzNzMxLTA0NjYtNDZhMC04NTUwLWQ4OWY3NjhiM2RiMSIsImV4cCI6MTUwMzI5MzMxMywiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiIsIlJPTEVfVVNFUiJdLCJqdGkiOiI5OWU2M2QyNi02M2E1LTQ3NWEtOWE4MC05ZjJhNjZiYzBmNWMiLCJjbGllbnRfaWQiOiJjbGllbnRpZCJ9.hPZZFhaNyZAPDZE89xw8iwGGXBeSaLcHujRqvuS_7J6LqdfogvlgevYdO_Y3yCN3zrVfozYLW1vmCtZ_VLToru2Ph-VkeT6FUogC7_8MbVkPMlOaCx-A0vmd3wbg3X2mj0qy9nOrnwSz_67hU8tAwli4IBgPOF-kJyQSzZs_ETjCyX7pHN9yAhzDpW6SKpQekpQfl2dcsjYvZMidzxh98ORT22aSM1h5l4KzIxY71kgBrmL5Rp-xVwiQFTT-4_ogO-ziPb_Y0YZBDEr3IxzQmyl-wh57ADUMVoxP3ij5tLNOjEbvs6mRnPFpni73MFSd1aTpgzKhAe_X_mORGlwUyQ",
  "expires_in" : 3599,
  "scope" : "read write",
  "jti" : "d8753731-0466-46a0-8550-d89f768b3db1"
}
```

## Resource Server

Untuk menjalankan Resource Server :

* Akses Folder Resource-Server
* Jalankan dengan perintah : `gradle bootRun`
* Server akan jalan di port 8081

Untuk dapat mengakses API silahkan jalankan perintah berikut :
```
curl "http://localhost:8081/api/barangs" \
  -H "Authorization: Bearer <access_token>" \
  -H "Content-Type: application/json"
```

Jika berhasil maka akan muncul output seperti berikut :

```
{
    "content": [
        "Aqua",
        "Rinso"
    ],
    "_links": {
        "self": {
            "href": "http://localhost:8081/api/barangs"
        }
    }
}
```
