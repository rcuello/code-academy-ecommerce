export const parseRequestUrl = () => {
    const url = document.location.hash.toLowerCase();
    // console.log(document.location.hash);
    // url = #/
    // url = #/product/2
    const request = url.split("/");

    //console.log(request);
    // request = #/             => ['#', '']
    // request = #/product/1    => ['#', 'product', '1']

    return {
        resource : request[1],
        id: request[2],
        action: request[3],
    };
}