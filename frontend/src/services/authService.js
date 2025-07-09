export const signUp = async (userData) => {
    try {
    const response = await fetch('http://localhost:7000/api/signup', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
      },
      body: JSON.stringify(userData),
    });

    const responseData = await response.json(); 

    if (!response.ok) {
     
      throw new Error(responseData.error || responseData.message || 'Registration failed');
    }

    return responseData;
    
  } catch (error) {
   
    if (error.name === 'SyntaxError') {
      throw new Error('Invalid server response');
    }
    throw error; 
  }
};