# UploadChallenge

1. Clone the repository using git clone.
2. Run the application using "grails run-app --port="
3. Hit the application link in browser.

Once application will be loaded:
1. Create a csv file named "usercsv" having value in the format x,y,z
2. Validations will be performed after uploading.
3. If No file uploaded then an info message will be displayed 'Please upload file'
4. if file contains data but failing some validation rules mentioned as a part of requirement, then line number will be highlighed on the UI.
5. if file will contain data and all validation passes then "data uploaded successfully" message will be displayed.
