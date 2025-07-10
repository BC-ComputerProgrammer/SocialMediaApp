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

export const login = async (userData) => {
  try {
    const response = await fetch('http://localhost:7000/api/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData),
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(errorData.error || 'Login failed');
      }

      return await response.json(); 
  } catch (error) {
    throw new Error(error.message || 'Network request failed');
  }
    
};