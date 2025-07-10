export const signUp = async (userData) => {
    try {
    const response = await fetch('http://localhost:7001/api/signup', {
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

export const login = async (userData) => {
  const response = await fetch('http://localhost:7001/api/login', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json',
      },
      body: JSON.stringify(userData),
  });

  let responseData = null;

  try {
      responseData = await response.json();
  } catch (parseError) {
      responseData = { error: 'Login failed (invalid server response)' };
  }

  if (!response.ok) {

      console.log("BACKEND SENT:", responseData);

      const error = new Error(); 
      error.response = { data: responseData };
      throw error;
  }

  return responseData;
};
