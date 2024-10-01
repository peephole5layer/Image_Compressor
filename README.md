
# Image Compressor 

### Application Description: **Image compressor using huffman coding **

The **Image Compressor** application is designed to provide users with a straightforward and effective tool for compressing images using two compression methods: JPEG and Huffman coding. The application features a graphical user interface (GUI) that allows users to easily upload images, choose compression settings, and view results.

#### Key Features:
1. User Interface (UI):
The application has a user-friendly interface built using Swing, making it accessible for users without technical expertise.
Users can easily upload an image file from their local system using a file chooser dialog.
A button allows users to initiate the compression process.

2. Image Compression Methods:

**JPEG Compression:** This method employs the JPEG format, which is widely used for compressing photographic images. It utilizes a lossy compression technique, reducing file size while maintaining an acceptable level of image quality.

**Huffman Coding:** In addition to JPEG, the application incorporates Huffman coding as a separate compression technique. This lossless method efficiently encodes pixel values based on their frequency in the image, generating variable-length codes to minimize file size.

3. Image Processing Logic:
The application reads the uploaded image and calculates pixel frequency for Huffman coding.
It builds a Huffman tree to generate binary codes for each pixel value.
The compressed images are saved with a new filename (prefixed with "compressed_") in the same directory as the original image.

4. Feedback and Notifications:
The application provides feedback to users, informing them when the compression is successful or if there are any errors during the process.




## Screenshots

![Screenshot 2024-10-01 214445](https://github.com/user-attachments/assets/9e5d92c6-f0c2-43e4-a97b-74b1f0d70ba3)
