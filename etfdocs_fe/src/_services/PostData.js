export function PostData(type, userData) {
    let ROOTURL = 'http://demo0038991.mockable.io/';

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