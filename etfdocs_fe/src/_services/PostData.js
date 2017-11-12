export function PostData(type, userData) {
    let ROOTURL = 'http://localhost:8000/';

    return new Promise((resolve, reject) => {
        fetch(ROOTURL + type, {
            method: 'POST',
            body: JSON.stringify(userData)
        })
        .then((response) => response.json())
        .then((res) => {
            resolve(res);
        })
        .catch((error) => {
            reject(error);
        });
    });
}   