function AddImage(props: any) {
  const uploadImage = async (e: any) => {
    let file = e.target.files[0];
    const base64: any = await convertBase64(file);
    const base64OnlyImage = base64.split(",")[1];
    props.onChangeImage(base64OnlyImage);
  };

  const convertBase64 = (file: File) => {
    return new Promise((resolve, reject) => {
      const fileReader = new FileReader();
      fileReader.readAsDataURL(file);

      fileReader.onload = () => {
        resolve(fileReader.result);
      };

      fileReader.onerror = (error) => {
        reject(error);
      };
    });
  };

  return (
    <div className="mx-auto">
      <input
        type="file"
        accept="image/jpg"
        onChange={(e) => uploadImage(e)}
      ></input>
    </div>
  );
}

export default AddImage;
