export const signUp = async (userData) => {
    try {
        const response = await fetch ('http://localhost:7000/api/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(userData),
        });

        if(!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.error || 'Signup failed');
        }

        return await response.json();
    } catch (error) {
        throw new Error(error.message || 'Network request failed');
    }
};