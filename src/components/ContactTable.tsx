import React from 'react';
import { Contact } from '../types';

interface ContactTableProps {
  contacts: Contact[];
  onCreateContact: () => void;
}

const ContactTable: React.FC<ContactTableProps> = ({ contacts, onCreateContact }) => {
  return (
    <div className="table-section">
      <div className="table-header">
        <h3>Contact Information</h3>
        <button className="create-button" onClick={onCreateContact}>
          + Create Contact
        </button>
      </div>
      <table className="data-table">
        <thead>
          <tr>
            <th>Type</th>
            <th>Value</th>
            <th>Primary</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {contacts.length === 0 ? (
            <tr>
              <td colSpan={4} className="no-data">
                No contacts found. Click "Create Contact" to add one.
              </td>
            </tr>
          ) : (
            contacts.map((contact) => (
              <tr key={contact.id}>
                <td>{contact.type}</td>
                <td>{contact.value}</td>
                <td>{contact.isPrimary ? 'Yes' : 'No'}</td>
                <td>
                  <button className="action-button">Edit</button>
                  <button className="action-button delete">Delete</button>
                </td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
};

export default ContactTable;