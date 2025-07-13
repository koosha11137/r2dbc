import React, { useState } from 'react';
import './App.css';
import PersonInfo from './components/PersonInfo';
import AddressTable from './components/AddressTable';
import ContactTable from './components/ContactTable';
import AddressModal from './components/AddressModal';
import ContactModal from './components/ContactModal';
import { Person, Address, Contact } from './types';

// Sample data
const samplePerson: Person = {
  id: '1',
  firstName: 'John',
  lastName: 'Smith',
  fatherName: 'Robert Smith',
  dateOfBirth: '1990-05-15',
  nationalId: 'ID123456789',
  occupation: 'Software Engineer'
};

function App() {
  const [activeTab, setActiveTab] = useState<'addresses' | 'contacts'>('addresses');
  const [addresses, setAddresses] = useState<Address[]>([
    {
      id: '1',
      type: 'Home',
      street: '123 Main Street',
      city: 'New York',
      state: 'NY',
      zipCode: '10001',
      country: 'USA'
    }
  ]);
  const [contacts, setContacts] = useState<Contact[]>([
    {
      id: '1',
      type: 'Phone',
      value: '+1-555-123-4567',
      isPrimary: true
    },
    {
      id: '2',
      type: 'Email',
      value: 'john.smith@email.com',
      isPrimary: false
    }
  ]);
  
  const [isAddressModalOpen, setIsAddressModalOpen] = useState(false);
  const [isContactModalOpen, setIsContactModalOpen] = useState(false);

  const handleCreateAddress = () => {
    setIsAddressModalOpen(true);
  };

  const handleCreateContact = () => {
    setIsContactModalOpen(true);
  };

  const handleSaveAddress = (addressData: Omit<Address, 'id'>) => {
    const newAddress: Address = {
      ...addressData,
      id: Date.now().toString()
    };
    setAddresses(prev => [...prev, newAddress]);
  };

  const handleSaveContact = (contactData: Omit<Contact, 'id'>) => {
    const newContact: Contact = {
      ...contactData,
      id: Date.now().toString()
    };
    setContacts(prev => [...prev, newContact]);
  };

  return (
    <div className="App">
      <div className="container">
        <PersonInfo person={samplePerson} />
        
        <div className="tabs-section">
          <div className="tabs">
            <button 
              className={`tab ${activeTab === 'addresses' ? 'active' : ''}`}
              onClick={() => setActiveTab('addresses')}
            >
              Addresses
            </button>
            <button 
              className={`tab ${activeTab === 'contacts' ? 'active' : ''}`}
              onClick={() => setActiveTab('contacts')}
            >
              Contact Information
            </button>
          </div>
          
          <div className="tab-content">
            {activeTab === 'addresses' && (
              <AddressTable 
                addresses={addresses} 
                onCreateAddress={handleCreateAddress}
              />
            )}
            {activeTab === 'contacts' && (
              <ContactTable 
                contacts={contacts} 
                onCreateContact={handleCreateContact}
              />
            )}
          </div>
        </div>
      </div>

      <AddressModal
        isOpen={isAddressModalOpen}
        onClose={() => setIsAddressModalOpen(false)}
        onSave={handleSaveAddress}
      />

      <ContactModal
        isOpen={isContactModalOpen}
        onClose={() => setIsContactModalOpen(false)}
        onSave={handleSaveContact}
      />
    </div>
  );
}

export default App;